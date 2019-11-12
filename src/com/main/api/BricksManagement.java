import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Order;

@RestController
public class BricksManagement {
   private static Map<String, Order> brickOrders = new HashMap<>();
   static {
      }
      
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
   public ResponseEntity<Object> addOrder(@RequestBody Order order) {
      brickOrders.put(order.getId(), order);
      return new ResponseEntity<>("Order is created successfully", HttpStatus.CREATED);
   }
   @RequestMapping(value = "/getOrders")
   public ResponseEntity<Object> getOrders() {
      return new ResponseEntity<>(brickOrders.values(), HttpStatus.OK);
   }
}
