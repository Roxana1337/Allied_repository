package automation.core;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataProvider {
    private static final String MATRICES_RATH = "Matrices" + File.separator;
    private static final String TEST_DATA_SHEET_NAME = "Sheet1";
    private static final String TEST_NAME_COLUMN_NAME = "TestName";
    private static final String REGISTRATION_PAGE_SPREADSHEET_NAME = "matrices.xlsx";
    private static final String LOGIN_PAGE_SPREADSHEET_NAME = "login.xlsx";

    private static final String LOGOUT_PAGE_SPREADSHEET_NAME = "logout.xlsx";

    private static final String UNREGISTER_PAGE_SPREADSHEET_NAME = "unregister.xlsx";

    private static final DataFormatter CELL_FORMATTER = new DataFormatter();

    @DataProvider(name = "RegistrationPageDataProvider")
    public static Object[][] registrationPageDataProvider() {
        return loadDataFromMatrix(REGISTRATION_PAGE_SPREADSHEET_NAME);
    }

    @DataProvider(name = "LoginPageDataProvider")
    public static Object[][] loginPageDataProvider() {
        return loadDataFromMatrix(LOGIN_PAGE_SPREADSHEET_NAME);
    }

    @DataProvider(name = "LogoutPageDataProvider")
    public static Object[][] logoutPageDataProvider() {
        return loadDataFromMatrix(LOGOUT_PAGE_SPREADSHEET_NAME);
    }

    @DataProvider(name = "UnregisterPageDataProvider")
    public static Object[][] unregisterPageDataProvider() {
        return loadDataFromMatrix(UNREGISTER_PAGE_SPREADSHEET_NAME);
    }

    private static Object[][] loadDataFromMatrix(String matrixName) {
        List<Map<String, String>> allTestData = new ArrayList<>();

        try (XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(new File(MATRICES_RATH + matrixName)))) {
            XSSFSheet testSheet = workBook.getSheet(TEST_DATA_SHEET_NAME);

// first row contains column names (keys)
            XSSFRow firstRow = testSheet.getRow(0);

// the number of columns (keys) in the first row
            short firstRowColumnCount = firstRow.getLastCellNum();

// if we do not have TestName as a first column, we throw an
// exception
            if (!CELL_FORMATTER.formatCellValue(firstRow.getCell(0)).equals(TEST_NAME_COLUMN_NAME)) {
                throw new IllegalStateException("First column in the matrix must have '" + TEST_NAME_COLUMN_NAME
                        + "' name, do you have it in your data sheet?");
            }
// total rows in the sheet (including header row with keys and all
// test cases)
            int rowsCount = testSheet.getLastRowNum();

// start from the second row because the first one is for keys
            for (int rowNumber = 1; rowNumber <= rowsCount; rowNumber++) {
                XSSFRow testDataRow = testSheet.getRow(rowNumber);

//                if (!CELL_FORMATTER.formatCellValue(testDataRow.getCell(0)).equals(matrixName.split("\\.")[0])) {
//                    continue;
//                }
// make sure it is not an empty row
                if (testDataRow != null) {
                    Map<String, String> singleTestData = new HashMap<>();

                    for (int columnNumber = 0; columnNumber < firstRowColumnCount; columnNumber++) {
                        XSSFCell keyCell = firstRow.getCell(columnNumber);
                        XSSFCell valueCell = testDataRow.getCell(columnNumber);

// make sure both cells are not empty
                        if (keyCell != null && valueCell != null) {
                            String key = CELL_FORMATTER.formatCellValue(keyCell);
                            String value = CELL_FORMATTER.formatCellValue(valueCell);

// add a single key/value pair to test data for
// current test row
                            singleTestData.put(key, value);
                        }
                    }

                    allTestData.add(singleTestData);
                }
            }

            workBook.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }

        Object[][] data = new Object[allTestData.size()][];

        for (int i = 0; i < allTestData.size(); i++) {
            Map<String, String> singleTestData = allTestData.get(i);
            data[i] = new Object[] { singleTestData };
        }

        return data;

    }

}
