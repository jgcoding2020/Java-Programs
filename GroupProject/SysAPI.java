/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingcart.cop4331_shoppingcart;

import java.util.LinkedList;
import java.util.Locale;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.math.BigDecimal;


/**
 * System API for Shopping Cart
 * Strategy pattern, Observer Pattern, Iterator Pattern, Decorator pattern, Adapter pattern
 * @author Group 12
 */
public class SysAPI {

    private LinkedList<Customer> listCust;
    private LinkedList<Seller> listSell;
    private Customer currentCust;
    private Seller currentSell;
    int check2 = 0;
    private JPanel cards;
    private JFrame frame;
    JPanel card1;
    JPanel card2;
    JPanel card3;
    JPanel card4;
    JPanel card5;

    /**
     * SysAPI constructor
     * Strategy pattern
     * @throws ClassNotFoundException
     */
    public SysAPI() throws ClassNotFoundException {

        // Card layout creation
        cards = new JPanel(new CardLayout());
        frame = new JFrame("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        card1 = new JPanel();
        card1.setLayout(new WrapLayout());
        cards.add(new JScrollPane(card1), "Seller");

        card3 = new JPanel();
        card3.setLayout(new WrapLayout());
        cards.add(new JScrollPane(card3), "Cart");

        card4 = new JPanel();
        card4.setLayout(new WrapLayout());

        card2 = new JPanel();
        card2.setLayout(new WrapLayout());
        cards.add(new JScrollPane(card2), "Customer");

        card5 = new JPanel();
        card5.setLayout(new WrapLayout());
        cards.add(new JScrollPane(card5), "CheckOut");
        listCust = new LinkedList();
        listSell = new LinkedList();

        // Listener will serialize upon exit
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    try ( FileOutputStream file = new FileOutputStream("List.dat");  ObjectOutputStream out = new ObjectOutputStream(file)) {

                        // Method for serialization of object
                        out.writeObject(listCust);
                        out.writeObject(listSell);
                    }
                    System.out.println("Sucessful");
                } catch (IOException ex) {
                    System.out.println("Unsuccessful");
                }
            }
        });

        try {
            try ( // Deserializes/ adds objects to linked lists
                     FileInputStream file = new FileInputStream("List.dat");  ObjectInputStream in = new ObjectInputStream(file)) {

                listCust.addAll((LinkedList<Customer>) in.readObject());

                listSell.addAll((LinkedList<Seller>) in.readObject());

            }
        } catch (IOException ex) {
        }

        //displays login API default
        this.LoginAPI();
        CardLayout cLayout = (CardLayout) (cards.getLayout());
        cLayout.show(cards, "Login");

    }

    /**
     * Assists in converting money string to int type
     *
     * @param amount String you want to converts
     * @param locale Location
     * @return BigDecimal
     * @throws ParseException
     */
    public static BigDecimal newParse(final String amount, final Locale locale) throws ParseException {
        final NumberFormat format = NumberFormat.getNumberInstance(locale);
        if (format instanceof DecimalFormat decimalFormat) {
            decimalFormat.setParseBigDecimal(true);
        }
        return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
    }

    /**
     * Grants capability to create account or login
     * Strategy pattern
     */
    public void LoginAPI() {

        // Welcome greeting
        JLabel ProductLabel = new JLabel("Welcome, please enter Username/Password");
        Font productFont = ProductLabel.getFont();
        float productSize = productFont.getSize() + 20.0f;
        ProductLabel.setFont(productFont.deriveFont(productSize));
        JPanel productLP = new JPanel();
        productLP.setLayout(new WrapLayout());
        productLP.setPreferredSize(new Dimension(1022, 55));
        productLP.add(ProductLabel);

        // If username/password do not match
        JLabel loginFail = new JLabel("Sorry your Username and Password don't match");
        loginFail.setFont(productFont.deriveFont(productSize - 10));
        JPanel noMatch = new JPanel();
        noMatch.setLayout(new WrapLayout());
        noMatch.setPreferredSize(new Dimension(1022, 55));
        noMatch.setVisible(false);
        noMatch.add(loginFail);

        // Username and password field logging in
        final JPanel secLogPanel = new JPanel();
        secLogPanel.setLayout(new BoxLayout(secLogPanel, BoxLayout.X_AXIS));

        JTextArea username = new JTextArea("Username:", 1, 6);
        Font font = username.getFont();
        float size = font.getSize() + 10.0f;
        username.setFont(font.deriveFont(size));
        username.setMargin(new Insets(10, 5, 5, 0));
        username.setEditable(false);

        JTextArea userText = new JTextArea("", 1, 10);
        userText.setEditable(true);
        userText.setFont(font.deriveFont(size));
        userText.setMargin(new Insets(10, 5, 5, 0));

        secLogPanel.add(username);
        secLogPanel.add(userText);

        final JPanel firstLogPanel = new JPanel();
        firstLogPanel.setLayout(new BoxLayout(firstLogPanel, BoxLayout.X_AXIS));

        JTextArea password = new JTextArea("Password:", 1, 6);
        password.setFont(font.deriveFont(size));
        password.setMargin(new Insets(10, 5, 5, 0));
        password.setEditable(false);

        JPasswordField passText = new JPasswordField(12);
        passText.setEditable(true);
        passText.setFont(font.deriveFont(size));
        passText.setMargin(new Insets(10, 5, 5, 0));

        firstLogPanel.add(password);
        firstLogPanel.add(passText);

        card4.add(noMatch);
        card4.add(productLP);
        card4.add(secLogPanel);
        card4.add(firstLogPanel);

        JButton signIn = new JButton("Login");
        signIn.setFont(font.deriveFont(size));

        // Login action listener
        signIn.addActionListener(new ActionListener() {
            private int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                //2 = Seller
                //1 = Customer
                //0 = fail log in
                String pass = new String(passText.getPassword());
                String username = userText.getText().toLowerCase();

                for (int attempt = 0; attempt < listCust.size(); attempt++) {
                    if (listCust.get(attempt).GetUsername().equals(username) && listCust.get(attempt).GetPassword().equals(pass)) {
                        i = 1;
                        currentCust = listCust.get(attempt);
                    }
                }
                for (int attempt = 0; attempt < listSell.size(); attempt++) {
                    if (listSell.get(attempt).GetUsername().equals(username) && listSell.get(attempt).GetPassword().equals(pass)) {
                        i = 2;
                        currentSell = listSell.get(attempt);
                    }
                }
                if (i == 1) {
                    CustomerAPI();
                    CardLayout cLayout = (CardLayout) (cards.getLayout());
                    cLayout.show(cards, "Customer");
                }
                if (i == 2) {
                    SellerAPI();
                    CardLayout cLayout = (CardLayout) (cards.getLayout());
                    cLayout.show(cards, "Seller");
                }
                if (i == 0) {
                    noMatch.setVisible(true);
                }
            }

        });

        card4.add(signIn);

        // New user creation
        JLabel newUserLabel = new JLabel("Welcome, Create new Customer/Seller account here");
        newUserLabel.setFont(productFont.deriveFont(productSize));
        JPanel newUserPanel = new JPanel();
        newUserPanel.setLayout(new BoxLayout(newUserPanel, BoxLayout.X_AXIS));
        newUserPanel.setPreferredSize(new Dimension(1022, 100));
        newUserPanel.setMinimumSize(new Dimension(1022, 100));
        newUserPanel.add(newUserLabel);

        final JPanel createUser1 = new JPanel();
        createUser1.setLayout(new BoxLayout(createUser1, BoxLayout.X_AXIS));

        JTextArea newUsername = new JTextArea("Username:", 1, 6);
        newUsername.setFont(font.deriveFont(size));
        newUsername.setMargin(new Insets(10, 5, 5, 0));
        newUsername.setEditable(false);

        JTextArea userText2 = new JTextArea("", 1, 10);
        userText2.setEditable(true);
        userText2.setFont(font.deriveFont(size));
        userText2.setMargin(new Insets(10, 5, 5, 0));

        createUser1.add(newUsername);
        createUser1.add(userText2);

        final JPanel createUser = new JPanel();
        createUser.setLayout(new BoxLayout(createUser, BoxLayout.X_AXIS));

        JTextArea password2 = new JTextArea("Password:", 1, 6);
        password2.setFont(font.deriveFont(size));
        password2.setMargin(new Insets(10, 5, 5, 0));
        password2.setEditable(false);

        JPasswordField passText2 = new JPasswordField(12);
        passText2.setEditable(true);
        passText2.setFont(font.deriveFont(size));
        passText2.setMargin(new Insets(10, 5, 5, 0));

        createUser.add(password2);
        createUser.add(passText2);

        // Determines user type created
        String[] select1 = {"Customer", " Seller"};

        JComboBox select = new JComboBox(select1);

        // Action listener button creates new user and logs user in
        JButton create = new JButton("Create");
        create.setFont(font.deriveFont(size));
        create.addActionListener((ActionEvent e) -> {
            // Empty box checker
            if (!"".equals(userText2.getText()) && passText2.getPassword().length != 0) {

                String name = userText2.getText().toLowerCase();
                String pass = new String(passText2.getPassword());

                // customer or seller selected verification
                if (select.getSelectedItem().equals(select1[0])) {
                    Customer temp = new Customer();
                    temp.SetUsername(name);
                    temp.SetPassword(pass);
                    listCust.add(temp);
                    currentCust = temp;

                    CustomerAPI();
                    CardLayout cLayout = (CardLayout) (cards.getLayout());
                    cLayout.show(cards, "Customer");
                } else {

                    Seller temp = new Seller();
                    temp.SetUsername(name);
                    temp.SetPassword(pass);
                    listSell.add(temp);
                    currentSell = temp;
                    SellerAPI();
                    CardLayout cLayout = (CardLayout) (cards.getLayout());
                    cLayout.show(cards, "Seller");
                }
            }
        });
        // Adds to cards
        card4.add(newUserLabel);
        card4.add(createUser1);
        card4.add(createUser);
        card4.add(select);
        card4.add(create);

        cards.add(card4, "Login");
        frame.add(cards);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * API for when Customer logs in successfully
     * Strategy pattern
     */
    public void CustomerAPI() {

        // Panel for items loaded
        final JPanel productPanel = new JPanel();
        productPanel.setLayout(new WrapLayout());

        // Greeting
        JLabel ProductLabel = new JLabel("Welcome, " + currentCust.GetUsername());
        Font productFont = ProductLabel.getFont();
        float productSize = productFont.getSize() + 20.0f;
        ProductLabel.setFont(productFont.deriveFont(productSize));
        JPanel productLP = new JPanel();
        productLP.setLayout(new BorderLayout());
        productLP.setPreferredSize(new Dimension(1022, 55));
        productLP.add(ProductLabel, BorderLayout.WEST);

        // Shopping cart button
        JButton shopButton = new JButton("Shopping Cart");
        shopButton.addActionListener((ActionEvent e) -> {
            card3.removeAll();
            ShoppingCart();
            CardLayout cLayout = (CardLayout) (cards.getLayout());
            cLayout.show(cards, "Cart");
        });

        productLP.add(shopButton, BorderLayout.EAST);
        card2.add(productLP);

        // Loop iterating seller accounts
        for (int attempt = 0; attempt < listSell.size(); attempt++) {
            Seller current = listSell.get(attempt);

            // Loop that iterates through every seller item and lists them
            for (int i = 0; i < current.ProdList().size(); i++) {

                // Current product 
                final Product thisProduct = current.ProdList().getItem(i);

                // Temp panel that loads all items
                final JPanel temp = new JPanel();
                temp.setLayout(new BoxLayout(temp, BoxLayout.X_AXIS));

                // Text area for name
                JTextArea productName = new JTextArea(thisProduct.Getname(), 4, 15);
                Font font = productName.getFont();
                float size = font.getSize() + 3.0f;
                productName.setFont(font.deriveFont(size + 6.0f));
                productName.setMargin(new Insets(2, 10, 0, 10));
                productName.setLineWrap(true);
                productName.setWrapStyleWord(true);

                // Text area for description 
                JTextArea description = new JTextArea(thisProduct.GetDescription(), 4, 20);
                description.setFont(font.deriveFont(size));
                description.setLineWrap(true);
                description.setWrapStyleWord(true);
                description.setMargin(new Insets(0, 10, 0, 10));
                JScrollPane d = new JScrollPane(description);
                d.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                // Text area for inventory
                JTextArea inventory = new JTextArea(Integer.toString(thisProduct.GetInventory()), 4, 5);
                inventory.setFont(font.deriveFont(size));
                inventory.setMargin(new Insets(20, 30, 0, 0));

                // Text area for price
                NumberFormat changeFormat = NumberFormat.getCurrencyInstance();
                JTextArea price = new JTextArea(changeFormat.format(thisProduct.GetPrice()), 4, 10);
                price.setFont(font.deriveFont(size));
                price.setMargin(new Insets(20, 30, 0, 0));

                // Inventory combobox
                String[] invCombo = new String[thisProduct.GetInventory() + 1];

                for (int k = 0; k < thisProduct.GetInventory() + 1; k++) {
                    invCombo[k] = Integer.toString(k);
                }

                JComboBox inbox = new JComboBox(invCombo);
                inbox.setSelectedIndex(0);
                inbox.setPreferredSize(new Dimension(50, 10));

                // Fields are set to false
                productName.setEditable(false);
                description.setEditable(false);
                inventory.setEditable(false);
                price.setEditable(false);

                // Add item button
                JButton addToCart = new JButton("Add To Cart");
                addToCart.setVisible(true);

                // Add items to shoppping cart action listener
                // Observer patttern
                ActionListener add = (ActionEvent e) -> {
                    int num = Integer.parseInt((String) inbox.getSelectedItem());

                    if (num > 0) {
                        // Creates product copy and changes inventory
                        Product newProductCopy = thisProduct.Getcopy();
                        newProductCopy.SetInventory(num);
                        currentCust.Add(newProductCopy);

                        // Sets the inventory for items
                        thisProduct.SetInventory(thisProduct.GetInventory() - num);

                        // Refreshes customer
                        card2.removeAll();
                        CustomerAPI();
                        card2.repaint();
                        card2.revalidate();

                        // Refreshes cart
                        card3.removeAll();
                        ShoppingCart();
                        card3.repaint();
                        card3.revalidate();
                    }
                };

                // Adds Listeners
                addToCart.addActionListener(add);

                // Adds componenets
                temp.add(productName);
                temp.add(d);
                temp.add(inventory);
                temp.add(price);
                temp.add(inbox);
                temp.add(addToCart);

                // Adds row to the product panel
                productPanel.add(temp);
            }
        }

        // Ensures scrolability and adds to card
        JScrollPane scroller = new JScrollPane(productPanel);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(1022, 700));
        card2.add(scroller);
        frame.pack();
    }

    /**
     * Show cart with products inside
     * Strategy pattern
     */
    public void ShoppingCart() {

        // Check to hide Successful Purchase label
        check2 = 0;
        // Panel that holds all products in cart
        JPanel theCart = new JPanel();
        theCart.setLayout(new WrapLayout());

        // Greeting
        JLabel ProductLabel = new JLabel("Shopping Cart:");
        Font productFont = ProductLabel.getFont();
        float productSize = productFont.getSize() + 20.0f;
        ProductLabel.setFont(productFont.deriveFont(productSize));
        JPanel productLP = new JPanel();
        productLP.setLayout(new BorderLayout());
        productLP.setPreferredSize(new Dimension(1022, 55));
        productLP.add(ProductLabel, BorderLayout.WEST);

        // Go back to shopping cart and refresh customerAPI
        // Observer pattern
        JButton mainPage = new JButton("Go Back Shopping");
        mainPage.addActionListener((ActionEvent e) -> {
            card2.removeAll();
            CustomerAPI();
            card2.repaint();
            card2.revalidate();
            CardLayout cLayout = (CardLayout) (cards.getLayout());
            cLayout.show(cards, "Customer");
        });
        productLP.add(mainPage, BorderLayout.EAST);

        // Takes cutomer to checkout
        // Observer pattern
        JButton next = new JButton("Check out");
        next.addActionListener((ActionEvent e) -> {
            card5.removeAll();
            CheckoutAPI();
            card5.repaint();
            card5.revalidate();
            CardLayout cLayout = (CardLayout) (cards.getLayout());
            cLayout.show(cards, "CheckOut");
        });
        productLP.add(next, BorderLayout.CENTER);

        card3.add(productLP);

        // Shopping cart products in a list
        for (int i = 0; i < currentCust.ProdList().size(); i++) {
            Product thisProduct = currentCust.ProdList().getItem(i);

            final JPanel temp = new JPanel();
            temp.setLayout(new BoxLayout(temp, BoxLayout.X_AXIS));

            // Name
            JTextArea productName = new JTextArea(thisProduct.Getname(), 4, 15);
            Font font = productName.getFont();
            float size = font.getSize() + 3.0f;
            productName.setFont(font.deriveFont(size + 6.0f));
            productName.setMargin(new Insets(2, 10, 0, 10));
            productName.setLineWrap(true);
            productName.setWrapStyleWord(true);

            // Description 
            JTextArea description = new JTextArea(thisProduct.GetDescription(), 4, 20);
            description.setFont(font.deriveFont(size));
            description.setLineWrap(true);
            description.setWrapStyleWord(true);
            description.setMargin(new Insets(0, 10, 0, 10));
            JScrollPane d = new JScrollPane(description);
            d.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            // Inventory
            JTextArea inventory = new JTextArea(Integer.toString(thisProduct.GetInventory()), 4, 5);
            inventory.setFont(font.deriveFont(size));
            inventory.setMargin(new Insets(20, 30, 0, 0));

            // Price
            NumberFormat changeFormat = NumberFormat.getCurrencyInstance();
            JTextArea price = new JTextArea(changeFormat.format((long) thisProduct.GetPrice()), 4, 10);
            price.setFont(font.deriveFont(size));
            price.setMargin(new Insets(20, 30, 0, 0));

            // Combobox to display how many items you want
            String[] invCombo = new String[thisProduct.GetInventory() + 1];

            for (int k = 0; k < thisProduct.GetInventory() + 1; k++) {
                invCombo[k] = Integer.toString(k);
            }

            JComboBox inbox = new JComboBox(invCombo);
            inbox.setSelectedIndex(thisProduct.GetInventory());
            inbox.setPreferredSize(new Dimension(50, 10));

            productName.setEditable(false);
            description.setEditable(false);
            inventory.setEditable(false);
            price.setEditable(false);

            // Update item button
            JButton update = new JButton("Update Item");
            update.setVisible(true);

            // Update shopping carts and inventory
            // Observer pattern
            ActionListener updateCart = (ActionEvent e) -> {
                int num = Integer.parseInt((String) inbox.getSelectedItem());
                if (num > 0) {
                    // Fix item inventory
                    int add = thisProduct.GetInventory() - num;
                    thisProduct.SetInventory(num);
                    // Fixes inventory for the Seller
                    for (int i1 = 0; i1 < listSell.size(); i1++) {
                        Seller current = listSell.get(i1);
                        for (int attempt = 0; attempt < current.ProdList().size(); attempt++) {
                            Product t = current.ProdList().getItem(attempt);

                            if (thisProduct.Getname().equals(t.Getname()) && thisProduct.GetDescription().equals(t.GetDescription()) && thisProduct.GetPrice() == t.GetPrice()) {
                                t.SetInventory(t.GetInventory() + add);
                                break;
                            }

                        }
                    }
                    card3.removeAll();
                    ShoppingCart();
                    card3.repaint();
                    card3.revalidate();
                } else {
                    currentCust.Remove(thisProduct);
                    theCart.remove(temp);
                    theCart.revalidate();
                    theCart.repaint();
                }
            };
            // Add Listeners
            update.addActionListener(updateCart);

            // Add componenets
            temp.add(productName);
            temp.add(d);
            temp.add(inventory);
            temp.add(price);
            temp.add(inbox);
            temp.add(update);
            theCart.add(temp);
        }

        JScrollPane scroller = new JScrollPane(theCart);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(1022, 700));

        card3.add(scroller);
        frame.pack();

    }

    /**
     * API for when Sellers successfully log in
     * Strategy pattern
     */
    public void SellerAPI() {

        // Main panel
        final JPanel productPanel = new JPanel();
        productPanel.setLayout(new WrapLayout());

        // Greet seller
        JLabel ProductLabel = new JLabel("View and Edit Products");
        Font productFont = ProductLabel.getFont();
        float productSize = productFont.getSize() + 20.0f;
        ProductLabel.setFont(productFont.deriveFont(productSize));

        JPanel productLP = new JPanel();
        productLP.setLayout(new BorderLayout());
        productLP.setPreferredSize(new Dimension(1022, 55));

        productLP.add(ProductLabel, BorderLayout.SOUTH);
        card1.add(productLP);

        // Linked list to hold items and panels
        final LinkedList<Product> temporaryProduct = new LinkedList();
        final LinkedList<JPanel> productPList = new LinkedList();

        // Header panel to show what the Product items are organized as
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        headerPanel.setPreferredSize(new Dimension(1022, 50));

        // Add text areas to Panel
        for (int i = 0; i < 1; i++) {
            JTextArea name = new JTextArea("Name", 2, 10);
            Font font = name.getFont();
            float size = font.getSize() + 10.0f;
            name.setFont(font.deriveFont(size));
            name.setMargin(new Insets(10, 10, 0, 0));
            name.setLineWrap(true);
            name.setWrapStyleWord(true);

            // Cost
            JTextArea cost = new JTextArea("Cost", 2, 10);
            cost.setFont(font.deriveFont(size));
            cost.setMargin(new Insets(10, 0, 0, 0));
            
            // Description 
            JTextArea description = new JTextArea("Description", 2, 5);
            description.setFont(font.deriveFont(size));
            description.setLineWrap(true);
            description.setWrapStyleWord(true);
            description.setMargin(new Insets(10, 10, 0, 0));
            JScrollPane d = new JScrollPane(description);
            d.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            // Inventory
            JTextArea inventory = new JTextArea("Inventory", 2, 10);
            inventory.setFont(font.deriveFont(size));
            inventory.setMargin(new Insets(10, 0, 0, 0));

            // Price
            JTextArea price = new JTextArea("Price", 2, 10);
            price.setFont(font.deriveFont(size));
            price.setMargin(new Insets(10, 0, 0, 0));

            // Save and edit buttons
            name.setEditable(false);
            cost.setEditable(false);
            description.setEditable(false);
            inventory.setEditable(false);
            price.setEditable(false);

            headerPanel.add(name);
            headerPanel.add(cost);
            headerPanel.add(description);
            headerPanel.add(inventory);
            headerPanel.add(price);
        }

        card1.add(headerPanel);

        // Get all items in current Sellers product list
        for (int i = 0; i < currentSell.ProdList().size(); i++) {

            final Product thisProduct = currentSell.ProdList().getItem(i);

            final JPanel temp = new JPanel();
            temp.setLayout(new BoxLayout(temp, BoxLayout.X_AXIS));

            // Text area
            JTextArea name = new JTextArea(thisProduct.Getname(), 4, 15);
            Font font = name.getFont();
            float size = font.getSize() + 3.0f;
            name.setFont(font.deriveFont(size + 6.0f));
            name.setMargin(new Insets(2, 10, 0, 10));
            name.setLineWrap(true);
            name.setWrapStyleWord(true);
            
            // Cost
            NumberFormat changeFormat = NumberFormat.getCurrencyInstance();
            JTextArea cost = new JTextArea(changeFormat.format(thisProduct.GetCost()), 4, 10);
            cost.setFont(font.deriveFont(size));
            cost.setMargin(new Insets(20, 30, 0, 0));

            // Description 
            JTextArea description = new JTextArea(thisProduct.GetDescription(), 4, 20);
            description.setFont(font.deriveFont(size));
            description.setLineWrap(true);
            description.setWrapStyleWord(true);
            description.setMargin(new Insets(0, 10, 0, 10));
            JScrollPane d = new JScrollPane(description);
            d.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            // Inventory
            JTextArea inventory = new JTextArea(Integer.toString(thisProduct.GetInventory()), 4, 10);
            inventory.setFont(font.deriveFont(size));
            inventory.setMargin(new Insets(20, 30, 0, 0));

            // Price
            JTextArea price = new JTextArea(changeFormat.format(thisProduct.GetPrice()), 4, 10);
            price.setFont(font.deriveFont(size));
            price.setMargin(new Insets(20, 30, 0, 0));

            // Save and edit buttons
            name.setEditable(false);
            cost.setEditable(false);
            description.setEditable(false);
            inventory.setEditable(false);
            price.setEditable(false);

            // Edit/save 
            JButton edit = new JButton(" Edit ");
            JButton save = new JButton("Save");
            save.setVisible(false);
            JCheckBox box = new JCheckBox();

            // Set text boxes to editbale
            ActionListener editable = (ActionEvent e) -> {
                name.setEditable(true);
                cost.setEditable(true);
                description.setEditable(true);
                inventory.setEditable(true);
                price.setEditable(true);
                edit.setVisible(false);
                save.setVisible(true);
            };

            // Sets text areas to uneditable and updates the UI
            // Observer pattern
            ActionListener saved;
            saved = (ActionEvent e) -> {
                int check1 = 0;
                int inventoryVal = 0;
                double priceVal = 0;
                double costVal = 0;
                try {
                    priceVal = newParse(price.getText(), Locale.US).doubleValue();
                    costVal = newParse(cost.getText(), Locale.US).doubleValue();
                    inventoryVal = newParse(inventory.getText(), Locale.US).intValue();
                } catch (ParseException attempt) {
                    check1 = 1;
                }
                // Update product
                if (check1 == 0) {
                    // Update price
                    thisProduct.SetPrice(priceVal);
                    price.replaceRange(changeFormat.format(thisProduct.GetPrice()), 0, price.getText().length());

                    // Update cost
                    thisProduct.SetCost(costVal);
                    cost.replaceRange(changeFormat.format(thisProduct.GetCost()), 0, cost.getText().length());
                    
                    // Update inventory
                    thisProduct.SetInventory(inventoryVal);
                    inventory.replaceRange(Integer.toString(thisProduct.GetInventory()), 0, inventory.getText().length());

                    // Update name
                    thisProduct.SetName(name.getText());

                    // Update description
                    thisProduct.SetDescription(description.getText());

                    // Update
                    // Refresh
                    card1.revalidate();
                    name.setEditable(false);
                    cost.setEditable(false);
                    description.setEditable(false);
                    inventory.setEditable(false);
                    price.setEditable(false);
                    edit.setVisible(true);
                    save.setVisible(false);
                    card1.removeAll();
                    SellerAPI();
                    card1.repaint();
                }
            };

            // Check box action listener
            ItemListener act = new ItemListener() {
                int check = 0;

                @Override
                public void itemStateChanged(ItemEvent e) {
                    // Add item to temporary linked list
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        temporaryProduct.add(thisProduct);
                        productPList.add(temp);
                        check = 1;
                    } // Remove items from temp linked list
                    else if (check == 1) {

                        temporaryProduct.remove(thisProduct);
                        productPList.remove(temp);
                        check = 0;
                    }

                }
            };

            // Add Listeners
            edit.addActionListener(editable);
            save.addActionListener(saved);
            box.addItemListener(act);

            // Add componenets
            temp.add(name);
            temp.add(cost);
            temp.add(d);
            temp.add(inventory);
            temp.add(price);
            temp.add(box);
            temp.add(edit);
            temp.add(save);

            productPanel.add(temp);
        }

        // Add new product to the sellers products and the API
        // observer pattern
        final JPanel newtemp = new JPanel();
        newtemp.setLayout(new BoxLayout(newtemp, BoxLayout.X_AXIS));

        for (int i = 0; i < 1; i++) {
            // Text area
            JTextArea name = new JTextArea("", 2, 16);
            Font font = name.getFont();
            float size = font.getSize() + 3.0f;
            name.setFont(font.deriveFont(size + 6.0f));
            name.setMargin(new Insets(2, 5, 0, 10));
            name.setLineWrap(true);
            name.setWrapStyleWord(true);

            // Cost
            JTextArea cost = new JTextArea("", 2, 10);
            cost.setFont(font.deriveFont(size));
            cost.setMargin(new Insets(2, 30, 0, 0));
            
            // Description 
            JTextArea description = new JTextArea("", 2, 21);
            description.setFont(font.deriveFont(size));
            description.setLineWrap(true);
            description.setWrapStyleWord(true);
            description.setMargin(new Insets(2, 10, 0, 10));
            JScrollPane d = new JScrollPane(description);

            // Inventory
            JTextArea inventory = new JTextArea("", 2, 10);
            inventory.setFont(font.deriveFont(size));
            inventory.setMargin(new Insets(2, 30, 0, 0));

            // Price
            JTextArea price = new JTextArea("", 2, 10);
            price.setFont(font.deriveFont(size));
            price.setMargin(new Insets(2, 30, 0, 0));
            
            // Save and edit buttons
            name.setEditable(true);
            cost.setEditable(true);
            description.setEditable(true);
            inventory.setEditable(true);
            price.setEditable(true);

            // Add new item to products list button
            JButton save = new JButton("Add Product");

            // Saves product listener adds it to the API
            ActionListener saved;
            saved = (ActionEvent e) -> {
                int check1 = 0;
                int inventoryVal = 0;
                double priceVal = 0;
                double costVal = 0;
                
                try {
                    priceVal = newParse(price.getText(), Locale.US).doubleValue();
                    costVal = newParse(cost.getText(), Locale.US).doubleValue();
                    inventoryVal = newParse(inventory.getText(), Locale.US).intValue();
                } catch (ParseException attempt) {
                    check1 = 1;
                }
                // Update product if not caught
                if (check1 == 0) {
                    // Update inventory
                    Product newP = new Product();

                    newP.SetPrice(priceVal);
                    price.setText(null);
                    
                    newP.SetCost(costVal);
                    cost.setText(null);

                    // Update Price
                    newP.SetInventory(inventoryVal);
                    inventory.setText(null);

                    // Update name
                    newP.SetName(name.getText());
                    name.setText(null);

                    // Update description
                    newP.SetDescription(description.getText());
                    description.setText(null);
                    currentSell.ProdList().add(newP);

                    // Refresh
                    card1.removeAll();
                    SellerAPI();
                    card1.repaint();
                    card1.revalidate();
                }
            };
            save.addActionListener(saved);
            newtemp.add(name);
            newtemp.add(cost);
            newtemp.add(d);
            newtemp.add(inventory);
            newtemp.add(price);
            newtemp.add(save);
        }

        JTextArea priceSet = new JTextArea("Set Price:", 1, 5);
        Font newFont = priceSet.getFont();
        float newSize = newFont.getSize() + 5.0f;
        priceSet.setEditable(false);
        priceSet.setFont(newFont.deriveFont(newSize));
        priceSet.setMargin(new Insets(2, 5, 2, 0));
        
        JTextArea numberPrice = new JTextArea("", 1, 55);
        numberPrice.setFont(newFont.deriveFont(newSize));
        numberPrice.setMargin(new Insets(2, 5, 2, 5));

        // Deletes selected products
        JPanel productButts = new JPanel();
        productButts.setPreferredSize(new Dimension(1000, 27));
        productButts.setLayout(new BoxLayout(productButts, BoxLayout.X_AXIS));
        JButton productDel = new JButton("Delete Selected Item(s)");
        productDel.addActionListener((ActionEvent e) -> {
            for (int i = 0; i < temporaryProduct.size(); i++) {
                currentSell.ProdList().remove(temporaryProduct.get(i));
            }

            temporaryProduct.clear();
            // Refresh
            card1.removeAll();
            SellerAPI();
            card1.repaint();
            card1.revalidate();
        });

        // Add panels to card
        JScrollPane scroller = new JScrollPane(productPanel);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(1022, 300));
        card1.add(scroller);
        card1.add(newtemp);
        productButts.add(productDel);
        productButts.add(priceSet);
        productButts.add(numberPrice);
        card1.add(productButts);

        // Gets sum stats
        int thisProduct = 0;
        int inventoryVal = 0;
        double sum = 0;
        double sumCost = 0;
        
        for (int i = 0; i < currentSell.ProdList().size(); i++) {

            Product t = currentSell.ProdList().getItem(i);
            sum = sum + t.GetPrice() * t.GetInventory();
            sumCost = sumCost + t.GetCost() * t.GetInventory();
            inventoryVal = inventoryVal + t.GetInventory();
            thisProduct++;
        }
        NumberFormat changeFormat = NumberFormat.getCurrencyInstance();

        String price = changeFormat.format(sum);
        String cost = changeFormat.format(sumCost);
        String revenue = changeFormat.format(currentSell.GetRevenue());
        String profit = changeFormat.format(currentSell.GetProfit());
        // Display sum stats
        JPanel totPanel = new JPanel();
        totPanel.setLayout(new BoxLayout(totPanel, BoxLayout.X_AXIS));

        JTextArea tot = new JTextArea("Total Price:", 1, 5);
        Font font = tot.getFont();
        float size = font.getSize() + 4.0f;
        tot.setFont(font.deriveFont(size + 5.0f));
        tot.setMargin(new Insets(10, 5, 5, 0));
        tot.setEditable(false);

        JTextArea totText = new JTextArea(price, 1, 10);
        totText.setEditable(false);
        totText.setFont(font.deriveFont(size));
        totText.setMargin(new Insets(14, 5, 5, 0));

        JTextArea totInven = new JTextArea("Total Inventory:", 1, 6);
        totInven.setFont(font.deriveFont(size + 5.0f));
        totInven.setMargin(new Insets(10, 5, 5, 0));
        totInven.setEditable(false);

        JTextArea totIT = new JTextArea(Integer.toString(inventoryVal), 1, 10);
        totIT.setEditable(false);
        totIT.setFont(font.deriveFont(size));
        totIT.setMargin(new Insets(14, 5, 5, 0));

        JTextArea totProducts = new JTextArea("Total Products:", 1, 6);
        totProducts.setFont(font.deriveFont(size + 5.0f));
        totProducts.setMargin(new Insets(10, 5, 5, 0));
        totProducts.setEditable(false);

        JTextArea totPT = new JTextArea(Integer.toString(thisProduct), 1, 10);
        totPT.setEditable(false);
        totPT.setFont(font.deriveFont(size));
        totPT.setMargin(new Insets(14, 5, 5, 0));
        
        totPanel.add(totProducts);
        totPanel.add(totPT);
        totPanel.add(totInven);
        totPanel.add(totIT);
        totPanel.add(tot);
        totPanel.add(totText);
        
        JPanel totPanel_2 = new JPanel();
        totPanel_2.setLayout(new BoxLayout(totPanel_2, BoxLayout.X_AXIS));

        JTextArea totProfit = new JTextArea("Total Profit:", 1, 5);
        totProfit.setFont(font.deriveFont(size + 5.0f));
        totProfit.setMargin(new Insets(10, 5, 5, 0));
        totProfit.setEditable(false);
        
        JTextArea totProfit2 = new JTextArea(profit, 1, 10);
        totProfit2.setEditable(false);
        totProfit2.setFont(font.deriveFont(size));
        totProfit2.setMargin(new Insets(14, 5, 5, 0));

        JTextArea totRevenue = new JTextArea("Total Revenue:", 1, 6);
        totRevenue.setFont(font.deriveFont(size + 5.0f));
        totRevenue.setMargin(new Insets(10, 5, 5, 0));
        totRevenue.setEditable(false);

        JTextArea totRevenue2 = new JTextArea(revenue, 1, 10);
        totRevenue2.setEditable(false);
        totRevenue2.setFont(font.deriveFont(size));
        totRevenue2.setMargin(new Insets(14, 5, 5, 0));

        JTextArea totCost = new JTextArea("Total Cost:", 1, 6);
        totCost.setFont(font.deriveFont(size + 5.0f));
        totCost.setMargin(new Insets(10, 5, 5, 0));
        totCost.setEditable(false);

        JTextArea totCost2 = new JTextArea(cost, 1, 10);
        totCost2.setEditable(false);
        totCost2.setFont(font.deriveFont(size));
        totCost2.setMargin(new Insets(14, 5, 5, 0));
        
        totPanel_2.add(totProfit);
        totPanel_2.add(totProfit2);
        totPanel_2.add(totRevenue);
        totPanel_2.add(totRevenue2);
        totPanel_2.add(totCost);
        totPanel_2.add(totCost2);

        card1.add(totPanel);
        card1.add(totPanel_2);
        frame.pack();
    }

    /**
     * API to allow users to checkout and confirm purchase
     * Strategy pattern
     * Observer pattern
     */
    public void CheckoutAPI() {
        // Main panel
        final JPanel mainView = new JPanel();
        mainView.setLayout(new BoxLayout(mainView, BoxLayout.Y_AXIS));

        // Show on purchase completion
        JLabel success = new JLabel("Purchase Successfull");
        Font font1 = success.getFont();
        float size1 = font1.getSize() + 10.0f;
        success.setFont(font1.deriveFont(size1));
        if (check2 == 0) {
            success.setVisible(false);
        } else {
            success.setVisible(true);
        }
        mainView.add(success);

        JPanel productLP = new JPanel();
        productLP.setLayout(new BorderLayout());

        // Refresh or allow user to go back
        JButton back = new JButton("Go Back to Shopping Cart");
        back.addActionListener((ActionEvent e) -> {
            card3.removeAll();
            ShoppingCart();
            card3.repaint();
            card3.revalidate();
            CardLayout cLayout = (CardLayout) (cards.getLayout());
            cLayout.show(cards, "Cart");
        });
        productLP.add(back, BorderLayout.WEST);
        mainView.add(productLP);

        // Panel for name
        JPanel productName = new JPanel();
        productName.setLayout(new BoxLayout(productName, BoxLayout.X_AXIS));

        JTextArea username = new JTextArea("             Name:", 1, 6);
        username.setEditable(false);
        Font font = username.getFont();
        float size = font.getSize() + 10.0f;
        username.setFont(font.deriveFont(size));
        username.setMargin(new Insets(10, 5, 5, 0));

        JTextArea userText = new JTextArea("", 1, 20);
        userText.setEditable(true);
        userText.setFont(font.deriveFont(size));
        userText.setMargin(new Insets(10, 0, 5, 0));

        productName.add(username);
        productName.add(userText);

        mainView.add(productName);

        // Panel for card
        JPanel cardNumber = new JPanel();
        cardNumber.setLayout(new BoxLayout(cardNumber, BoxLayout.X_AXIS));

        JTextArea card = new JTextArea("Card Number:", 1, 6);
        card.setFont(font.deriveFont(size));
        card.setMargin(new Insets(10, 5, 5, 0));
        card.setEditable(false);

        JTextArea cardText = new JTextArea("", 1, 20);
        cardText.setEditable(true);
        cardText.setFont(font.deriveFont(size));
        cardText.setMargin(new Insets(10, 5, 5, 0));

        cardNumber.add(card);
        cardNumber.add(cardText);

        mainView.add(cardNumber);

        // Gets sum amount in shopping cart
        double sum = 0;
        for (int i = 0; i < currentCust.ProdList().size(); i++) {

            Product t = currentCust.ProdList().getItem(i);
            sum = sum + t.GetPrice() * t.GetInventory();
        }
        NumberFormat changeFormat = NumberFormat.getCurrencyInstance();

        String price = changeFormat.format(sum);

        JPanel totPanel = new JPanel();
        totPanel.setLayout(new BoxLayout(totPanel, BoxLayout.X_AXIS));

        JTextArea tot = new JTextArea("              Total:", 1, 6);
        tot.setFont(font.deriveFont(size));
        tot.setMargin(new Insets(10, 5, 5, 0));
        tot.setEditable(false);

        JTextArea totText = new JTextArea(price, 1, 20);
        totText.setEditable(false);
        totText.setFont(font.deriveFont(size));
        totText.setMargin(new Insets(10, 5, 5, 0));

        totPanel.add(tot);
        totPanel.add(totText);
        mainView.add(totPanel);

        // Confirm puchase button
        JButton endPurchase = new JButton("Confirm Purchase");
        endPurchase.addActionListener((ActionEvent e) -> {
            double TotalRev;
            double saleProfit;
            // Allow user to press button only if all fields are filled out
            if (!cardText.getText().equals("") && !userText.getText().equals("")) {
                // Calculates revenue and profit for sellers based on products purchased
                // Loop for currentCust product iteration
                for (int i = 0; i < currentCust.ProdList().size(); i++){
                    // Loop for listSell Seller iteration
                    for (int j = 0; j < listSell.size(); j++){
                        // Loop for listSell Seller ProdList iteration
                        for (int n = 0; n < listSell.get(j).ProdList().size(); n++){
                            if (currentCust.ProdList().getItem(i).Getname().equals(listSell.get(j).ProdList().getItem(n).Getname())){
                                TotalRev = listSell.get(j).GetRevenue() + currentCust.ProdList().getItem(i).GetPrice();
                                listSell.get(j).SetRevenue(TotalRev); 
                                saleProfit = listSell.get(j).ProdList().getItem(n).GetPrice() - listSell.get(j).ProdList().getItem(n).GetCost();
                                listSell.get(j).SetProfit(listSell.get(j).GetProfit() + saleProfit);
                            }
                        }
                    }
                }
                // Remove all from shopping cart
                currentCust.ProdList().removeAll();
                System.out.println("Cleared");

                // Refresh
                card5.removeAll();
                // Allows the payment successfull panel to show
                check2 = 1;
                CheckoutAPI();
                card5.repaint();
                card5.revalidate();
            }
        });
        mainView.add(endPurchase);

        card5.add(mainView);
        frame.pack();
    }

    /**
     * Starts System when this file is ran
     *
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {
        // Starts API
        SysAPI openSystem = new SysAPI();
    }
}
