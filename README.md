

# WealthWatch

The **Financial Web App** is a Spring Boot-based application designed to facilitate the management and analysis of financial portfolios, investment transactions, and stock market data. The app empowers users to organize their investments, monitor performance, and make informed financial decisions.

## Key Functions

### User Authentication and Authorization

- Users can create accounts, log in, and authenticate using JSON Web Tokens (JWT).
- JWT tokens contain user information, roles, and scopes for secure and controlled access.
- Role-based and scope-based authorization is enforced using Spring Security's `@PreAuthorize` annotations.

### Portfolio Management

- Users can create, update, and delete portfolios to categorize their investments.
- Each portfolio is associated with a user and contains a collection of investment transactions.

### Investment Transactions

- Users can add investment transactions to their portfolios, including details such as transaction type, stock symbol, shares, and price per share.
- Investment transactions are tracked and associated with the respective portfolio.

### Stock Market Data

- The app integrates with external APIs or services to retrieve real-time or historical stock market data.
- Stock market data may include stock prices, market indices, and other relevant financial metrics.

### User Profiles

- Users can view and manage their profile information, including username, email, and other relevant details.

