# Accounting Ledger Application

## Project Description

The Accounting Ledger Application is a robust Java-based financial tracking system that allows users to manage their financial transactions efficiently. The application provides a comprehensive set of features for recording deposits and payments, viewing transaction history, and generating custom reports based on various criteria.

### Key Features:

- **Transaction Management**: Add deposits and payments with detailed information
- **Ledger Viewing**: See all transactions, filter by deposits or payments only
- **Advanced Reporting**: Generate reports filtered by:
  - Time periods (Month-to-Date, Previous Month, Year-to-Date, Previous Year)
  - Vendor search
  - Custom search with multiple parameters (date range, description, vendor, amount)
- **CSV Integration**: Transactions are saved to and loaded from a CSV file for data persistence

## Application Screenshots

### Home Screen

<img width="273" alt="Screenshot 2025-05-01 at 3 11 11 PM" src="https://github.com/user-attachments/assets/0780d6d4-e179-42a1-91c1-470ba9d51928" />


### Ledger Screen

<img width="273" alt="Screenshot 2025-05-01 at 3 11 36 PM" src="https://github.com/user-attachments/assets/4a238743-5552-4095-a7de-07671b72a9d9" />


### Reports Screen

<img width="338" alt="Screenshot 2025-05-01 at 3 12 05 PM" src="https://github.com/user-attachments/assets/9d0567b6-eed9-46a0-be15-f2e106233b9e" />


### Transaction Display Example
```
2023-01-25|15:46:22|Website hosting|Amazon|-$12.99
2023-02-10|08:35:47|Monitor stand|Amazon|-$34.99
2023-04-15|10:13:25|Ergonomic keyboard|Amazon|-$89.50
```

## Interesting Code: Custom Search Functionality

One of the most powerful features of the application is the custom search feature, which allows users to filter transactions based on multiple criteria simultaneously:

```java
public static void customSearch(Scanner scanner) {
    System.out.print("Enter start date: ");
    LocalDate startDate = LocalDate.parse(scanner.nextLine());
    System.out.print("Enter end date: ");
    LocalDate endDate = LocalDate.parse(scanner.nextLine());
    System.out.print("Enter description to filter: ");
    String inputDesc = scanner.nextLine();
    System.out.print("Enter vendor to filter: ");
    String inputVendor = scanner.nextLine();
    System.out.print("Enter amount to filter: ");
    int inputAmount = (int) scanner.nextFloat();

    for(Transactions transaction : App.transactions) {
        LocalDate transDate = transaction.getDate();
        String transDesc = transaction.getDescription();
        String transVendor = transaction.getVendorName();
        int transAmount = (int) transaction.getAmount();

        boolean dateMatch = (startDate.isEqual(transDate) || transDate.isAfter(startDate)) && 
                           (endDate.isEqual(transDate) || transDate.isBefore(endDate));

        boolean descMatch = inputDesc.isEmpty() || 
                           transDesc.toLowerCase().contains(inputDesc.toLowerCase());

        boolean vendorMatch = inputVendor.isEmpty() || 
                             inputVendor.equalsIgnoreCase(transVendor);

        boolean amountMatch = inputAmount == 0 || inputAmount == transAmount;

        if(dateMatch && descMatch && vendorMatch && amountMatch) {
            System.out.println(transaction);
        }
    }
    report(scanner);
}
```

This code is particularly interesting because it demonstrates:

1. **Flexible filtering logic**: The code uses boolean logic to apply filters only when values are provided, making searches highly adaptable.
2. **Compound conditions**: Multiple search criteria are combined with AND operations, allowing for precise filtering.
3. **Case-insensitive searching**: The application applies case-insensitive matching for text fields.
4. **Date range handling**: The code intelligently handles date ranges using Java's LocalDate comparison methods.

## Technical Implementation

The application is built using:
- Java core libraries
- Object-oriented principles with clear class separation
- File I/O for data persistence
- Scanner for user input handling
- Java 8+ date/time API (LocalDate, LocalTime)

## Getting Started

1. Clone this repository
2. Ensure you have Java JDK 8+ installed
3. Compile the project: `javac com/pluralsight/*.java`
4. Run the application: `java com.pluralsight.App`

## Future Enhancements

- GUI implementation
- Authentication system
- Data visualization and charts
- Budget tracking features
- Export reports to PDF/Excel
