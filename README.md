## 📂 Project Structure

```text
OnlineFoodOrderingSystem/
│
├── factories/                   # Factory Design Pattern (order creation)
│   ├── Noworderfactory.java
│   ├── Orderfactory.java
│   └── Scheduleorderfactory.java
│
├── managers/                    # Managers for handling business logic
│   ├── Ordermanager.java
│   └── Resturantmanager.java
│
├── models/                      # Core domain models
│   ├── Cart.java
│   ├── Deliveryorder.java
│   ├── MenuItem.java
│   ├── Order.java
│   ├── Pickuporder.java
│   ├── Resturant.java
│   └── User.java
│
├── services/                    # Services for notifications, etc.
│   └── Notification.java
│
├── strategies/                  # Strategy Design Pattern (payment methods)
│   ├── Card.java
│   ├── Paymentstrategy.java
│   └── Upipayment.java
│
├── utils/                       # Utility/helper classes
│
├── Main.java                    # Entry point
└── TomatoApp.java               # Facade/Orchestrator
