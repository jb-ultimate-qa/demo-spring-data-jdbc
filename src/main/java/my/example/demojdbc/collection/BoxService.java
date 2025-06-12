package my.example.demojdbc.collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class BoxService {

    private final BoxRepository boxRepository;

    public BoxService(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    @Transactional
    public Box createSampleBox() {
        Box box = new Box();
        box.setVolume(10.5);

        Item1 item1a = new Item1("Apple");
        Item1 item1b = new Item1("Banana");

        Item2 item2a = new Item2("Cereal");
        Item2 item2b = new Item2("Donut");

        Item3 item3a = new Item3("Egg");
        Item3 item3b = new Item3("Fish");

        box.setItems1(List.of(item1a, item1b));
        box.setItems2(Set.of(item2a, item2b));
        Map<String, Item3> item3Map = new HashMap<>();
        item3Map.put("my-key-1", item3a);
        item3Map.put("my-key-2", item3b);
        box.setItems3(item3Map);

        return boxRepository.save(box);
    }

    public Optional<Box> getBox(int id) {
        return boxRepository.findById(id);
    }

    public Iterable<Box> getAllBoxes() {
        return boxRepository.findAll();
    }

    @Transactional
    public void updateBoxVolume(int id, double newVolume) {
        boxRepository.findById(id).ifPresent(box -> {
            box.setVolume(newVolume);
            boxRepository.save(box);
        });
    }

    @Transactional
    public void replaceAllItems(int boxId) {
        Optional<Box> optionalBox = boxRepository.findById(boxId);
        if (optionalBox.isEmpty()) {
            System.out.println("Box with ID " + boxId + " not found.");
            return;
        }
        Box box = optionalBox.get();

        // Replace items1 list
        List<Item1> newItems1 = List.of(
                new Item1(null, "Item1-Updated-A"),
                new Item1(null, "Item1-Updated-B")
        );
        box.setItems1(newItems1);

        // Replace items2 set
        Set<Item2> newItems2 = Set.of(
                new Item2(null, "Item2-Updated-A"),
                new Item2(null, "Item2-Updated-B")
        );
        box.setItems2(newItems2);

        // Replace items3 map
        Map<String, Item3> newItems3 = new HashMap<>();
        newItems3.put("newKey1", new Item3(null, "Item3-Updated-A"));
        newItems3.put("newKey2", new Item3(null, "Item3-Updated-B"));
        box.setItems3(newItems3);

        boxRepository.save(box);

        System.out.println("Items in Box ID " + boxId + " were updated.");
    }

    @Transactional
    public void replaceFirstItems(int boxId) {
        Optional<Box> optionalBox = boxRepository.findById(boxId);
        if (optionalBox.isEmpty()) {
            System.out.println("Box with ID " + boxId + " not found.");
            return;
        }
        Box box = optionalBox.get();

        // ----- Modify List<Item1> -----
        if (box.getItems1() != null) {
            box.getItems1().add(new Item1("Item1-Added"));
            box.getItems1().remove(0); // remove first
        }

        // ----- Modify Set<Item2> -----
        if (box.getItems2() != null) {
            box.getItems2().add(new Item2("Item2-Added"));
            box.getItems2().stream().findFirst().ifPresent(box.getItems2()::remove); // remove one
        }

        // ----- Modify Map<String, Item3> -----
        if (box.getItems3() != null) {
            box.getItems3().put("addedKey", new Item3(null, "Item3-Added"));
            String firstKey = box.getItems3().keySet().iterator().next();
            box.getItems3().remove(firstKey); // remove first
        }

        boxRepository.save(box);

        System.out.println("Modified one item in each collection in Box ID " + boxId);
    }

    @Transactional
    public void updateItemFields(int boxId, String key) {
        Optional<Box> optionalBox = boxRepository.findById(boxId);
        if (optionalBox.isEmpty()) {
            System.out.println("Box with ID " + boxId + " not found.");
            return;
        }
        Box box = optionalBox.get();

        // ----- Update field in Item1 -----
        if (!box.getItems1().isEmpty()) {
            Item1 item1 = box.getItems1().get(0);
            item1.setName1(item1.getName1() + " [Updated]");
        }

        // ----- Update field in Item2 -----
        if (!box.getItems2().isEmpty()) {
            Item2 item2 = box.getItems2().iterator().next();
            item2.setName2(item2.getName2() + " [Updated]");
        }

        // ----- Update field in Item3 (by key) -----
        if (box.getItems3().containsKey(key)) {
            Item3 item3 = box.getItems3().get(key);
            item3.setName3(item3.getName3() + " [Updated]");
        }

        boxRepository.save(box);

        System.out.println("Updated one field in each collection item for Box ID " + boxId);
    }


    public void deleteBox(int id) {
        boxRepository.deleteById(id);
    }
}
