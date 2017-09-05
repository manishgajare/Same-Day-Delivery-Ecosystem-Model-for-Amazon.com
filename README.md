# Same-Day-Delivery-Ecosystem-Model-for-Amazon.com
business model for Global Same Day Delivery to customers of Amazon.com implemented in Java (J2SE)

PROBLEM STATEMENT


- The system removes the dependency of Amazon on physical warehouses by connecting to customers through the Local Retailers.

- The system selects the Local Retailers that are in close proximity to the delivery destination given by the customer.

- The algorithm designed to serve  this purpose uses Have sine formula to calculate distance from latitude & longitude 

SOLUTION


- The system removes the dependency of Amazon on physical warehouses by connecting to customers through the Local Retailers.

- The system selects the Local Retailers that are in close proximity to the delivery destination given by the customer.

- The algorithm designed to serve  this purpose uses Haversine formula to calculate distance from latitude & longitude of the delivery destination and all the local Retailers. 

- The algorithm calculates the longitude & latitude based on their Pin Codes.

ASSUMPTIONS & BUSINESS RULES


- If local Retailers have a contract with Amazon then its assumed that the product delivery will be done in a day. Amazon monitors the processing and delivery time through the work queues

- Penalized amount per day is assumed to be  10% of the total amount of the order.

- The customer pays Amazon the total amount of the order & Amazon then deducts his commission which is 10%  and penalized amount if any .He then passes the deducted amount to retailer.

