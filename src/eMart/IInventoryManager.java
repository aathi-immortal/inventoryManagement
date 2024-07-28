package src.eMart;

import java.util.List;

public interface IInventoryManager {

    public void generateReport();

    public List<Item> getAllItems();

    public void addItem(Item item);

    public void removeItem(int id);
}
