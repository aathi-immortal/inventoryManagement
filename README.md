Open the Project in Visual Studio Code
Open Visual Studio Code.
Open the cloned project directory:
Click on File > Open Folder....
Navigate to the directory where you cloned the project.
Select the project folder and click Open.
Set Up the SQLite JDBC Driver
In Visual Studio Code, locate the Java project in the Explorer sidebar.
Find the Referenced Libraries section under the Java project.
Click on the + icon next to Referenced Libraries.
Add the SQLite JAR file:
Download the SQLite JDBC driver from https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.36.0.3.
Navigate to the location where you downloaded the JAR file.
Select the JAR file and add it to the project.
Usage
Adding an Item
To add an item to the inventory, use the addItem method of the InventoryManager class.

Retrieving All Items
To retrieve all items from the inventory, use the getAllItems method of the InventoryManager class.

Removing an Item
To remove an item from the inventory, use the removeItem method of the InventoryManager class.

Generating a Report
To generate a report of all items in the inventory, use the generateReport method of the InventoryManager class.
