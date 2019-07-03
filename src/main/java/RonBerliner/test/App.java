package RonBerliner.test;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class App 
{
	private static Logger logger = Logger.getLogger(App.class);
	private static ObjectMapper mapper = new ObjectMapper();
	
    public static void main( String[] args )
    {
        ObjectNode node = constructNode();

        try {
        logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node));
        } catch(Exception e) {
        	System.out.println(e);
        }
    }
    
    public static ObjectNode constructNode() {
    	ObjectNode node = mapper.createObjectNode();
        node.put("firstName", "Ron");
        node.put("lastName", "Berliner");
        node.put("age", 41);
        
        ObjectNode address = mapper.createObjectNode();     
        address.put("streetAddress", "Katsenelson 84B");
        address.put("city", "Givatayim");
        address.put("postalCode", 5327717);
        
        node.put("address", address);
        
        ArrayNode phones = mapper.createArrayNode();
        
        ObjectNode cell = mapper.createObjectNode();
        cell.put("type", "mobile");
        cell.put("number", "+972- 522750687");
        
        ObjectNode home = mapper.createObjectNode();
        home.put("type", "home");
        home.put("number", "+972- 37327902");
        
        phones.add(cell);
        phones.add(home);
        
        node.put("phoneNumbers", phones);
        
        return node;
    }
}