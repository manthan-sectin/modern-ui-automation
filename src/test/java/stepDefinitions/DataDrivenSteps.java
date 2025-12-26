//package stepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//import pageObjects.LoginPage;
//import pageObjects.ProductsPage;
//import utilities.JsonDataReader;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//public class DataDrivenSteps {
//    private LoginPage loginPage;
//    private ProductsPage productsPage;
//    private List<Map> testData;
//    
//    @Given("User has the test data from {string}")
//    public void user_has_the_test_data_from(String dataFile) throws IOException {
//        testData = JsonDataReader.readJsonArray(
//                "src/test/resources/testData/" + dataFile, 
//                Map.class);
//    }
//    
//    @When("User tries to login with data row {int}")
//    public void user_tries_to_login_with_data_row(Integer rowIndex) {
//        Map<String, String> data = testData.get(rowIndex);
//        loginPage = new LoginPage();
//        loginPage.login(data.get("username"), data.get("password"));
//    }
//    
//    @Then("The login should be {string} for row {int}")
//    public void the_login_should_be_for_row(String expectedResult, Integer rowIndex) {
//        if ("successful".equals(expectedResult)) {
//            productsPage = new ProductsPage();
//            Assert.assertTrue(productsPage.getInventoryItemsCount() > 0, 
//                    "Login was not successful for row " + rowIndex);
//        } else {
//            Map<String, String> data = testData.get(rowIndex);
//            String actualErrorMessage = loginPage.getErrorMessage();
//            Assert.assertTrue(actualErrorMessage.contains(data.get("expectedError")),
//                    "Error message mismatch for row " + rowIndex);
//        }
//    }
//}