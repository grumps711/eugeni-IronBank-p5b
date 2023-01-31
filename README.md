

# Final Project: Iron Banking System
![](final-cover.png)

- [Final Project: Iron Banking System](#final-project-iron-banking-system)
  - [The project](#the-project)
    - [Accounts](#accounts)
      - [Checking Accounts](#checking-accounts)
      - [StudentChecking Accounts](#studentchecking-accounts)
      - [Savings Accounts](#savings-accounts)
      - [CreditCard Accounts](#creditcard-accounts)
    - [Users](#users)
      - [AccountHolders](#accountholders)
      - [Admins](#admins)
      - [ThirdParty](#thirdparty)
    - [Interest and Fees](#interest-and-fees)
    - [Checking Accounts](#checking-accounts-1)
    - [Account Access](#account-access)
    - [Transactions](#transactions)
    - [Reports](#reports)
    - [Security](#security)
    - [Fraud Detection](#fraud-detection)
    - [Technical Requirements](#technical-requirements)
    - [Testing](#testing)
    - [Documentation](#documentation)
  - [More explainations](#more-explainations)
    - [Account Holder](#account-holder)
    - [Admin](#admin)
    - [Third Party User](#third-party-user)
    - [Checking account](#checking-account)
    - [StudentChecking account](#studentchecking-account)
    - [Saving account](#saving-account)
    - [Credit Card](#credit-card)
  - [Bonus](#bonus)
    - [Bonus Features](#bonus-features)
    - [Advanced Bonus](#advanced-bonus)
  - [Tips](#tips)




As you embark on your final project for the Ironhack Java Bootcamp, you are about to take on a challenging and rewarding experience. The project will be the culmination of all the knowledge and skills you have acquired throughout the program. You will be building a comprehensive **banking system** that will include various account types such as Checking, Savings, CreditCard and StudentChecking. You will be designing and implementing the system using your knowledge of Java and Object-Oriented Programming concepts.

The project will also require you to work independently and apply problem-solving skills to overcome any obstacles that may arise. You will be responsible for designing the system architecture, implementing the functionality, and testing the system. The system will include a login system, transactions, reports, and security features. You will also be responsible for documenting the code, design, and implementation. Additionally, the system should be compliant with industry standards and regulations.

Throughout the project, you will have the opportunity to demonstrate your ability to write clean, readable, and maintainable code, as well as your ability to work independently and think critically. The final project is an opportunity for you to showcase your skills and demonstrate your readiness for the next step in your career. Remember to reach out to the instructional staff for assistance if needed, and good luck!

## The project

### Accounts

The system must have 4 types of accounts: StudentChecking, Checking, Savings, and CreditCard.

#### Checking Accounts

- Balance
- SecretKey
- PrimaryOwner
- Optional SecondaryOwner
- MinimumBalance
- PenaltyFee
- MonthlyMaintenanceFee
- CreationDate
- Status (FROZEN, ACTIVE)

#### StudentChecking Accounts

Identical to Checking Accounts except that they do NOT have a monthly maintenance fee or a minimum balance.

#### Savings Accounts

Identical to Checking Accounts except that they do NOT have a monthly maintenance fee, but do have an interest rate.

```
Default interest rate: 0.0025
Maximum interest rate: 0.5
Default minimum balance: 1000
Minimum balance may be instantiated with a value less than 1000 but no lower than 100
```
#### CreditCard Accounts
- Balance
- PrimaryOwner
- Optional SecondaryOwner
- CreditLimit
- InterestRate
- PenaltyFee
    
```
Default credit limit: 100
Credit limit may be instantiated with a value higher than 100 but not higher than 100000
Default interest rate: 0.2
Interest rate may be instantiated with a value less than 0.2 but not lower than 0.1
 ```
    

### Users

The system must have 3 types of Users: Admins, AccountHolders, and ThirdParty Accounts.

---
#### AccountHolders


Access their own accounts and only their accounts when passing the correct credentials using Basic Auth.
- Name
- Date of birth
- PrimaryAddress (which should be a separate address class)
- Optional mailingAddress

---
#### Admins


Only have a name
- Can create new accounts (Checking, Savings, or CreditCard Accounts)
- Can create new AccountHolders, Admin, or ThirdParty
---
#### ThirdParty

- Hashed key ( this field will be passed in the header for every call they made)
- Name

In order to receive and send money, Third-Party Users must provide their hashed key in the header of the HTTP request. They also must provide the amount, the Account id and the account secret key
---
### Interest and Fees

PenaltyFee for all accounts is 40.
- If any account drops below the minimumBalance, the penaltyFee is automatically deducted from the balance.

Interest on savings accounts is added to the account annually at the rate of specified interestRate per year.
- Interest on credit cards is added to the balance monthly.

### Checking Accounts

- When creating a new Checking account, if the primaryOwner is less than 24, a StudentChecking account should be created, otherwise a regular Checking Account should be created.
- Checking accounts should have a minimumBalance of 250 and a monthlyMaintenanceFee of 12.

### Account Access

- Admins can access the balance for any account and modify it.
- AccountHolders can only access their own accounts with the correct credentials using Basic Auth.

### Transactions

The system should be able to handle basic transactions such as deposit, withdraw, and transfer between accounts. For money you should use the [Money.class](https://gist.githubusercontent.com/GazzD/a2d8a92ac0b46858070d08bbc4cc4f40/raw/eaf48efd7c191ba1c518f93484e9ce9b6d79e653/Money.java)
The system should be able to check for account status and minimum balance before processing transactions.

The system should be able to apply transaction fees if applicable.

### Reports

The system should be able to generate reports on account activity, transaction history, and account balances.

The system should be able to provide account statements on a monthly or yearly basis.

The system should be able to provide reports on account holders' demographics and account types.

### Security

The system should have proper security measures in place to protect user information and account information.

The system should have a login system in place for account holders and administrators.

The system should have a way to reset passwords in case of lost or forgotten passwords.


### Fraud Detection

The system should have a fraud detection feature that recognizes patterns that indicate suspicious activity and alerts the system administrator.

The system should be able to freeze the account status when potential fraud is detected to prevent further unauthorized transactions.

The system should be able to monitor transactions for patterns such as:
- Transactions made in a 24 hour period that total more than 150% of the customer's highest daily total transactions in any other 24 hour period.
- More than 2 transactions occurring on a single account within a 1 second period.

### Technical Requirements

- The system should be built using Java and Spring Boot for the backend.
- The system should use a MySQL database to store data.
- The system should have routes for at least GET, POST, PUT/PATCH, and DELETE.
- The system should use Spring Security for authentication.
- The system should have unit and integration tests.
- The system should have robust error handling to ensure that it can handle any potential errors.
- The system should use the Money class for all currency and BigDecimal for any other decimal or large number math.

### Testing

- The system should be thoroughly tested before being deployed.
- The system should be tested for functionality, security, and performance.
- The system should be tested for compliance with industry standards and regulations.

### Documentation

- The system should have proper documentation for the code, design, and implementation.

- The system should have a user manual for account holders and administrators.
  
---

Please note that this is a high-level overview of the requirements for the project. Additional details and specifications may be provided by the instructional staff.

## More explainations



### Account Holder
**Account Holder User**: Account holder users are customers of the bank who have one or more accounts with the bank. They have access to the system to view their account information, perform transactions, and manage their account settings. Account holders have a direct relationship with the bank and are able to access the system using their personal information and credentials, such as a username and password.

 ```
Example: An account holder user could be an individual who has a checking account, a savings account, and a credit card with the bank. The individual would be able to access the system using their personal information and credentials to view their account balances, view their transaction history, transfer funds between accounts, and manage their account settings. The individual would also be able to view their account information and perform transactions using the bank's online banking platform.
 ```
  ```
Another example, an account holder user could be a business that has a checking account and a credit card with the bank. The business would be able to access the system using its business information and credentials to view its account balances, view its transaction history, transfer funds between accounts, and manage its account settings. The business would also be able to view its account information and perform transactions using the bank's online banking platform.
 ```
It's important to note that account holder users have a direct relationship with the bank and have access to sensitive information, it's important to have a secure and controlled access to the system for this type of users, as well as to have a proper monitoring and auditing of their activities.


### Admin

**Admin User**: Admin users are employees of the bank who have access to the system to manage and maintain the system. They have access to the system to view and modify account information, perform transactions, and manage system settings. Admin users have a direct relationship with the bank and are able to access the system using their employee information and credentials, such as a username and password.
 ```
Example: An admin user could be a customer service representative who has access to the system to view and modify account information, perform transactions, and manage system settings. The customer service representative would be able to access the system using their employee information and credentials to view and modify customer account information, perform transactions, and manage system settings. They would also be able to view and modify account information and perform transactions using the bank's online banking platform.
 ```
  ```
Another example, an admin user could be an IT administrator who has access to the system to manage and maintain the system. The IT administrator would be able to access the system using their employee information and credentials to manage and maintain the system. They would also be able to view and modify account information and perform transactions using the bank's online banking platform.
 ```
It's important to note that admin users are employees of the bank and have access to sensitive information and control over the system, it's important to have a secure and controlled access to the system for this type of users, as well as to have a proper monitoring and auditing of their activities.

### Third Party User
**Third Party User**: Third party users are external entities that have access to the system to perform specific actions. These users are typically organizations or individuals that provide services to the bank or its customers. They do not have access to customer account information, but they are able to perform specific actions such as processing transactions or providing account information to customers.

 ```
Example: A third party user could be a company that provides online bill pay services. This company would have access to the banking system's API to process payments on behalf of the bank's customers. The company would not have access to the customer's account information, but it would be able to process transactions on the customer's behalf. In this case, the company would need to authenticate itself to the system using a hashed key and a name.
 ```
  ```
Another example, a third party user could be a credit reporting agency that has access to the system to retrieve credit information on behalf of the bank's customers. The agency would not have access to the customer's account information, but it would be able to retrieve credit information to provide credit reports to the bank's customers. In this case, the agency would need to authenticate itself to the system using a hashed key and a name.
 ```
It's important to note that Third Party users are different than normal users, as they don't have a direct relationship with the bank, but they are able to perform actions on the bank's behalf, it's also important to establish a secure and controlled access to the system for this type of users, as well as to have a proper monitoring and auditing of their activities.


### Checking account 

**Checking Account**: A checking account is a type of bank account that allows customers to deposit and withdraw funds, write checks, and make electronic transactions. Checking accounts typically have lower interest rates than savings accounts, but they also have lower fees and minimum balance requirements. These accounts are designed to be used for everyday transactions, such as paying bills and making purchases.


It's important to note that Checking accounts are designed to be used for everyday transactions, they generally have lower interest rates than savings accounts and they also have lower fees and minimum balance requirements.

### StudentChecking account 

**Student Checking Account**: A student checking account is a type of checking account that is designed specifically for students. These accounts have features that are tailored to the needs of students, such as lower fees and minimum balance requirements. 


It's important to note that Student Checking accounts are designed specifically for students, they have lower fees and minimum balance requirements.

### Saving account
**Saving Account**: A savings account is a type of bank account that allows customers to deposit and withdraw funds, and earn interest on their deposits. Savings accounts typically have higher interest rates than checking accounts, but they also have higher fees and minimum balance requirements. These accounts are designed to be used for long-term savings and to grow the customer's wealth.

It's important to note that Saving accounts are designed to be used for long-term savings and to grow the customer's wealth, they generally have higher interest rates than checking accounts, but they also have higher fees and minimum balance requirements.

### Credit Card

**Credit Card Account**: A credit card account is a type of account that allows customers to make purchases and withdraw cash on credit. Credit card accounts typically have a credit limit, which is the maximum amount that can be borrowed, and an interest rate, which is the rate at which interest is charged on the outstanding balance. The customer must pay back the borrowed amount plus interest. These accounts are designed to be used for short-term borrowing and to make purchases that the customer may not be able to afford upfront.


It's important to note that Credit Card accounts are designed to be used for short-term borrowing and to make purchases that the customer may not be able to afford upfront, they typically have a credit limit and an interest rate, and the customer must pay back the borrowed amount plus interest.

## Bonus

### Bonus Features

- Implement a transaction history feature that allows account holders to view their past transactions. This could include the date, amount, and type of transaction.

- Implement an account statement feature that allows account holders to view their account activity for a specific period of time, such as a month or a year.

- Implement a feature that allows account holders to set up automatic transfers between accounts, such as a savings account and a checking account.

- Implement a feature that allows account holders to set up recurring payments, such as paying bills automatically.

- Implement a feature that allows account holders to set up notifications for specific account activities, such as low balance or suspicious activity.

- Implement a feature that allows account holders to view and manage their account information, such as personal information and contact details.

- Implement a feature that allows account holders to set up and manage security features, such as account passwords and security questions.

- Implement a feature that allows account holders to set up and manage account settings, such as language preference and time zone.

### Advanced Bonus

- Containerize the application using Docker, allowing for easy deployment and scalability.

- Deploy the application to a cloud platform such as AWS, Linode, IBMCloud or GCP, and set up load balancing and auto-scaling.

- Implement advanced security like JWT.

- Implement observability features such as monitoring and logging, to ensure that the system is running smoothly and to quickly detect and diagnose any issues.

- Create a front-end interface that allows account holders to interact with the system, such as view account information, make transactions, and manage settings.

- Implement a microservices architecture using Spring Boot or Quarkus to break down the monolithic application into smaller, more manageable services.

- Use Kubernetes to orchestrate the containerized application, automate rollouts and rollbacks, and horizontal scaling.

- Use a tool like Prometheus to monitor and collect metrics from the application and use Grafana to visualize the data.

- Use a tool like ELK (Elasticsearch, Logstash, Kibana) to collect, store, and analyze logs from the application.

## Tips
Here are some tips to help you with the final project of an Ironhack Java Bootcamp:

1. Plan ahead: Before you start coding, take some time to plan out the project. Break it down into smaller tasks and create a timeline for completing each task. This will help you stay on track and ensure that you don't miss any important deadlines.

2. Start with the basics: Begin by implementing the basic functionality of the system, such as account creation and login functionality. Once you have the basic functionality in place, you can then move on to more advanced features.

3. Write clean, readable code: As you write the code, make sure to follow best practices for writing clean, readable, and maintainable code. This will make it easier for you and others to understand and modify the code in the future.

4. Test your code: As you write the code, make sure to test it thoroughly to ensure that it is working as expected. This will help you catch and fix any bugs early on in the development process.

5. Get feedback: As you work on the project, make sure to get feedback from your instructional staff and classmates. They can provide valuable insights and suggestions that can help you improve the project.

6. Take care of the documentation: The system should have proper documentation for the code, design, and implementation. Make sure you document your code and design so that it's easy to understand and use.

7. Stay organized: Keep your files and folders organized, so you don't lose track of what you are doing. This will help you stay on track and ensure that you don't miss any important deadlines.

8. Don't be afraid to ask for help: If you get stuck or need help, don't hesitate to reach out to your instructional staff. They are there to help and support you throughout the project.

9. Remember the security: Keep in mind the security of the system, ensure that user information and account information are protected.

10. Have fun: Remember that the final project is a learning experience and an opportunity to showcase your skills. Stay positive and have fun!

    

Hope this tips help you in the process of the final project.
