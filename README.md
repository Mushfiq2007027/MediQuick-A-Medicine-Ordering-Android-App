# MediQuick - A Medicine Ordering Android App

## 🚀 Main Features

1. **Signup Option**: New users can create an account by providing necessary information, ensuring a personalized and secure experience.

2. **Login**: Existing users can securely log in to access their profiles, order history, and other personalized features.

3. **Checking Medicines with Discount**: Users can browse and find medicines that are currently on discount, making it easy to save money on essential purchases.

4. **Choose Category**: Users can select from various categories of medicines, facilitating quick and easy navigation to the products they need.

5. **Check Medicine According to Category**: Within each category, users can view all available medicines, helping them find specific items based on their requirements.

6. **Each Medicine Has Its Own Description**: Detailed descriptions for each medicine, including uses, dosage, side effects, and price, are provided to help users make informed decisions.

7. **Add to Cart Option**: Users can add selected medicines to their shopping cart, review their selections, and modify quantities as needed.

8. **Order Placing Option**: Users can proceed to place orders for the medicines in their cart, choosing delivery options.

---

## 🧱 Design Pattern

**Activity Package:**

- `IntroActivity.java`: Singleton Design Pattern
- `SignupActivity.java`: Factory Design Pattern
- `LoginActivity.java`: Factory Design Pattern
- `BaseActivity.java`: Singleton Design Pattern
- `ListMedicinesActivity.java`: Factory Design Pattern

**Adapter Package:**

- All classes in this package follow the Adapter Design Pattern.

---

## ✅ Unit Testing

We have performed unit testing for the classes in the Domain package.

Tested Classes:

1. `CategoryTest.java`  
2. `MedicinesTest.java`  
3. `LocationTest.java`  
4. `PriceTest.java`  
5. `TimeTest.java`

---

## 🧪 Instrumentation Testing

Instrumentation testing was performed using:

- `DomainInstrumentedTest.java`

---

## 🖥️ UI Testing

UI testing was performed for:

1. `SignupActivity.java`  
2. `LoginActivity.java`  

Test Classes:

- `SignupActivityTest.java`  
- `LoginActivityTest.java`

---

## 📄 Documentation

**Javadoc Comments**:  
Comprehensive Javadoc comments have been added to the codebase. These comments facilitate the generation of detailed API documentation and help developers understand the code structure, functionality, and usage of different classes and methods.

> Javadoc comments have been added to all classes under the Activity package.

---

## 📱 Snapshot of App

<table>
  <tr>
    <td><b>Splash Screen</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/4a171ffa-178c-4099-92ac-68662e39c538" width="200"/></td>
    <td><b>Signup Screen</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/2ad0151f-adad-4423-a769-d43988c362da" width="200"/></td>
    <td><b>Login Screen</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/2afa7ce7-a325-4df7-af5a-7106fec3f4ce" width="200"/></td>
  </tr>
  <tr>
    <td><b>Main Page</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/e4453bcd-b0b3-4f38-aac4-85fdac6f3dbc" width="200"/></td>
    <td><b>Categorywise Medicine List</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/efa140fd-6294-4e33-adc5-75608a1e456c" width="200"/></td>
    <td><b>Medicine Details Page</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/92e0bf67-8846-4ae0-a9a3-0ba24eefe502" width="200"/></td>
  </tr>
  <tr>
    <td colspan="3" align="center"><b>Cart Page</b><br><img src="https://github.com/Mushfiq2007027/MediQuick-A-Medicine-Ordering-Android-App/assets/132667084/e689dd9e-f533-4e88-9c17-904a6a84d796" width="300"/></td>
  </tr>
</table>
