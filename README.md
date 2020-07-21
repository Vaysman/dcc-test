# dcc-test
Just an application to show the difference in behavior between 2.2.7 and 2.2.8

## How to test

1. Checkout tag v2.2.7
   ```bash
   git checkout v2.2.7
   ```
   
1. Run test and all tests will pass
   ```bash
   ./mvnw clean test
   ```

1. Checkout tag v2.2.8
   ```bash
   git checkout v2.2.7
   ```

1. Run test and one test will pass, but the outher will fail
   ```bash
   ./mvnw clean test
   ```
   
1. [difference between v2.2.7 and v2.2.8](https://github.com/Vaysman/dcc-test/compare/v2.2.7..v2.2.8)
