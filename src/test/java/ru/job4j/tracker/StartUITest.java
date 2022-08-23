package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "New item name", "1"});
        UserAction[] actions = {new EditAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenShowActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        tracker.add(new Item("test2"));
        String created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"));
        Input in = new StubInput(new String[] {"0", "1"});
        UserAction[] actions = new UserAction[]{new ShowAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Item{id=1, name='test1', created=" + created + '}' + ln
                        + "Item{id=2, name='test2', created=" + created + '}' + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        tracker.add(new Item("test2"));
        String created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"));
        Input in = new StubInput(new String[] {"0", "2", "1"});
        UserAction[] actions = new UserAction[]{new FindByIdAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Item{id=2, name='test2', created=" + created + '}' + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1"));
        tracker.add(new Item("test2"));
        String created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"));
        Input in = new StubInput(new String[] {"0", "test", "1"});
        UserAction[] actions = new UserAction[]{new FindByNameAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Заявки с именем: test не найдены." + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"9", "0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Add new Item" + ln
                        + "1. Show all items" + ln
                        + "2. Edit item" + ln
                        + "3. Delete item" + ln
                        + "4. Find item by id" + ln
                        + "5. Find items by name" + ln
                        + "6. Exit Program" + ln
        );
    }
}