# MediQuick — A Medicine Ordering Android Application

---

## Table of Contents

- [Main Features](#main-features)
- [Design Patterns](#design-patterns)
- [Unit Testing](#unit-testing)
- [Instrumentation Testing](#instrumentation-testing)
- [UI Testing](#ui-testing)
- [Documentation](#documentation)
- [Application Screenshots](#application-screenshots)

---

## Main Features

1. **User Registration** — New users can create a personal account by submitting the required information, establishing a secure and individualized application experience.

2. **User Authentication** — Registered users can securely log in to access their profile, order history, and all associated personalized functionality.

3. **Discounted Medicines** — The application provides a dedicated view of medicines currently available at discounted prices, enabling users to identify cost-effective options for essential purchases.

4. **Category Selection** — Medicines are organized into clearly defined categories, allowing users to navigate efficiently to the product segment relevant to their needs.

5. **Category-wise Medicine Listing** — Within each selected category, users can browse the complete inventory of available medicines, facilitating targeted product discovery.

6. **Medicine Detail View** — Each medicine entry includes a comprehensive description covering its intended uses, recommended dosage, potential side effects, and pricing information, empowering users to make informed purchasing decisions.

7. **Shopping Cart** — Users can add medicines to a persistent shopping cart, review their selected items, and adjust quantities prior to checkout.

8. **Order Placement** — Users can finalize and submit orders for the items in their cart, with available delivery options presented during the checkout process.

---

## Design Patterns

### Activity Package

| Class | Design Pattern Applied |
|---|---|
| `IntroActivity.java` | Singleton |
| `SignupActivity.java` | Factory |
| `LoginActivity.java` | Factory |
| `BaseActivity.java` | Singleton |
| `ListMedicinesActivity.java` | Factory |

### Adapter Package

All classes within the Adapter package conform to the **Adapter Design Pattern**.

---

## Unit Testing

Unit testing has been conducted for all classes within the Domain package. The following test classes were implemented:

1. `CategoryTest.java`
2. `MedicinesTest.java`
3. `LocationTest.java`
4. `PriceTest.java`
5. `TimeTest.java`

---

## Instrumentation Testing

Instrumentation testing was carried out using the following test class:

- `DomainInstrumentedTest.java`

---

## UI Testing

User interface testing was performed for the registration and authentication flows. The following activity and test class pairs were covered:

| Activity | Test Class |
|---|---|
| `SignupActivity.java` | `SignupActivityTest.java` |
| `LoginActivity.java` | `LoginActivityTest.java` |

---

## Documentation

Comprehensive Javadoc comments have been integrated throughout the codebase to support automated API documentation generation and to provide developers with clear, structured insight into the purpose, behavior, and usage of each class and method.

> Javadoc annotations have been applied to all classes within the Activity package.

---

## Application Screenshots

<table>
  <tr>
    <td><b>Splash Screen</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/4a171ffa-178c-4099-92ac-68662e39c538" width="200"/></td>
    <td><b>Signup Screen</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/2ad0151f-adad-4423-a769-d43988c362da" width="200"/></td>
    <td><b>Login Screen</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/2afa7ce7-a325-4df7-af5a-7106fec3f4ce" width="200"/></td>
  </tr>
  <tr>
    <td><b>Main Page</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/e4453bcd-b0b3-4f38-aac4-85fdac6f3dbc" width="200"/></td>
    <td><b>Category-wise Medicine List</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/efa140fd-6294-4e33-adc5-75608a1e456c" width="200"/></td>
    <td><b>Medicine Details Page</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/92e0bf67-8846-4ae0-a9a3-0ba24eefe502" width="200"/></td>
  </tr>
  <tr>
    <td colspan="3" align="center"><b>Cart Page</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/e689dd9e-f533-4e88-9c17-904a6a84d796" width="300"/></td>
  </tr>
</table>
