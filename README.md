📦 Logistic Management System 🚚

The Logistic Management System is a backend project developed using advanced Java with Spring Boot, MySQL, Maven, REST API, and Postman. This system manages logistics operations such as shipment tracking, inventory management, and order processing. Here’s a brief description of its core components and functionalities:
Core Components:

    Spring Boot Application 🌱:
        Purpose: Provides a robust framework for building and running the application.
        Features: Dependency injection, auto-configuration, and embedded servers for seamless development and deployment.

    MySQL Database 🗄️:
        Purpose: Stores all the data related to shipments, inventory, orders, and users.
        Features: Relational database management system that handles data persistence and queries.

    Maven Project ⚙️:
        Purpose: Manages project dependencies and build lifecycle.
        Features: Simplifies the build process with a structured project layout and dependency management.

    REST API 🌐:
        Purpose: Facilitates communication between the client and server using HTTP requests.
        Features: Provides endpoints for CRUD operations (Create, Read, Update, Delete) on logistic entities like shipments, inventory, and orders.

    Postman 📬:
        Purpose: Tool for testing and interacting with REST APIs.
        Features: Allows sending HTTP requests to endpoints, validating responses, and automating API tests.

Key Functionalities:

    Shipment Tracking 🚛:
        Endpoints:
            POST /shipments: Create a new shipment.
            GET /shipments/{id}: Retrieve shipment details by ID.
            PUT /shipments/{id}: Update shipment status or details.
            DELETE /shipments/{id}: Delete a shipment.

    Inventory Management 📦:
        Endpoints:
            POST /inventory: Add new items to the inventory.
            GET /inventory: Retrieve a list of all inventory items.
            PUT /inventory/{id}: Update inventory item details.
            DELETE /inventory/{id}: Remove items from the inventory.

    Order Processing 📋:
        Endpoints:
            POST /orders: Create a new order.
            GET /orders/{id}: Retrieve order details by ID.
            PUT /orders/{id}: Update order status or details.
            DELETE /orders/{id}: Cancel an order.


Spring Boot Application Configuration:

java

@SpringBootApplication
public class LogisticManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogisticManagementSystemApplication.class, args);
    }
}

Shipment Entity:

java

@Entity
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String status;

    // Getters and Setters
}

Shipment Repository:

java

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}

Shipment Controller:

java

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentRepository shipmentRepository;

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @GetMapping("/{id}")
    public Shipment getShipment(@PathVariable Long id) {
        return shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id, @RequestBody Shipment shipmentDetails) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        shipment.setDescription(shipmentDetails.getDescription());
        shipment.setStatus(shipmentDetails.getStatus());
        return shipmentRepository.save(shipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        shipmentRepository.delete(shipment);
        return ResponseEntity.ok().build();
    }
}

Testing with Postman:

    Creating a Shipment: Use the POST /shipments endpoint with JSON payload to create a new shipment.
    Retrieving a Shipment: Use the GET /shipments/{id} endpoint with the shipment ID to retrieve details.
    Updating a Shipment: Use the PUT /shipments/{id} endpoint with the shipment ID and JSON payload to update details.
    Deleting a Shipment: Use the DELETE /shipments/{id} endpoint with the shipment ID to delete it.
