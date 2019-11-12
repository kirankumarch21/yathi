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
   //Sample Data for testing
   static {
      Order order1 = new Order("12345","order 1","address 1", "ORDER_CREATED", 100);
      Order order2 = new Order("12346","order 2","address 2", "ORDER_DISPATCHED", 200);
      Order order3 = new Order("12347","order 3","address 3", "ORDER_CANCELLED", 300);
      brickOrders.put(order1.getId(), order1);
      brickOrders.put(order2.getId(), order2);
      brickOrders.put(order3.getId(), order3);
      }
   
   //For Adding orders - Stage 1
   @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
   public ResponseEntity<Object> addOrder(@RequestBody Order order) {
      brickOrders.put(order.getId(), order);
      return new ResponseEntity<>("Order is created successfully", HttpStatus.CREATED);
   }
   
   //For getting all the list of orders - stage 1
   @RequestMapping(value = "/orders")
   public ResponseEntity<Object> getOrders() {
      return new ResponseEntity<>(brickOrders.values(), HttpStatus.OK);
   }
   
   //For getting specific order detials - stage 1
   @RequestMapping(value = "/getOrder/{id}", method=RequestMethod.GET)
   public ResponseEntity<Object> getOrderbyID(@PathVariable("id") String id) {
      Order orderDetails = brickOrders.get(id);
      if(orderDetails != null){
         return new ResponseEntity<>(orderDetails, HttpStatus.OK);
      }else{
         return new ResponseEntity<>("No Order Details Found", HttpStatus.BAD_REQUEST);
      }
   }
   
   //For updating the order details with new no of bricks - Stage 2
   @RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Order order) { 
      Order orderDetails = brickOrders.get(order.getId());
      if(orderDetails.getOrderStatus().equals("ORDER_DISPATCHED")){
         return new ResponseEntity<>("Your Order is already dispatched, We can't update it now." , HttpStatus.BAD_REQUEST);
      }else{
         orderDetails.setNoOfBricks(order.getNoOfBricks());
         return new ResponseEntity<>("Order is updated successsfully. Order # "+ order.getId(), HttpStatus.OK);
      }
   }
   
   //For updating the order details with order status- Stage 3 and Stage 4
   @RequestMapping(value = "/orders/{orderStatus}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("orderStatus") String orderStatus, @RequestBody Order order) { 
      Order orderDetails = brickOrders.get(order.getId());
      if(orderDetails != null){
         orderDetails.setOrderStatus(orderStatus);
         return new ResponseEntity<>("Order #"+orderDeails.getId()+" and status is updated to "+orderStatus, HttpStatus.OK);
      }else if(orderDetails.getOrderStatus().equals("ORDER_DISPATCHED")){
         return new ResponseEntity<>("Your Order is already dispatched, We can't update it now." , HttpStatus.BAD_REQUEST);
      }else{
         return new ResponseEntity<>("No Order Details Found", HttpStatus.BAD_REQUEST);
      }
   }
   
}
