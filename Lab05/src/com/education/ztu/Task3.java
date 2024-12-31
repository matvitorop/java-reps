package com.education.ztu;
import java.util.*;


public class Task3 {
    protected final static class PriceComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return Double.compare(p1.getPrice(), p2.getPrice());
        }
    }

    public static void iteration (List<Product> list){
        ListIterator<Product> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.nextIndex() +" - "+  iterator.next());
        }
    }
    public static void skipPlaceAndTask(String text){
        System.out.println();
        System.out.println(text);
    }

    public static void main(String[] args) {


        List<Product> products = new ArrayList<Product>();
        List<Product> anotherProducts = new ArrayList<Product>();
        Product productOne = new Product("Banana", 3000, 100, "food");
        Product productTwo = new Product("Apple", 1000, 50, "food");
        Product productThree = new Product("Iphone", 45000, 333, "technique");
        Product productFour = new Product("Samsung", 12, 666, "technique");
        Product productFive = new Product("Bottle", 12345, 123, "plastic products");
        Product productSix = new Product("Lamp", 54321, 321, "technique");

        //add
        anotherProducts.add(productOne);
        anotherProducts.add(productTwo);
        anotherProducts.add(productThree);
        anotherProducts.add(productFour);
        anotherProducts.add(productFive);
        anotherProducts.add(productSix);

        //addAll
        products.addAll(anotherProducts);
        iteration(products);

        //get
        skipPlaceAndTask("Get: ");

        System.out.println(products.get(0));

        //indexOf
        skipPlaceAndTask("IndexOf: ");

        System.out.println("Element has "+products.indexOf(productThree)+" index");

        //lastIndexOf
        skipPlaceAndTask("lastIndexOf: ");

        products.add(productThree);
        System.out.println("Last index of element 3 is "+products.lastIndexOf(productThree));

        //iterator
        skipPlaceAndTask("iterator. Elements in array: ");

        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //ListIterator
        skipPlaceAndTask("ListIterator: ");
        ListIterator<Product> listIterator = products.listIterator();
        System.out.println("Iteration with listIterator:");

        while (listIterator.hasNext()) {
            System.out.println(listIterator.nextIndex());
            System.out.println("Next: "+listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previousIndex());
            System.out.println("Previous: "+listIterator.previous());
        }


        //remove
        skipPlaceAndTask("Elements after removing: ");
        products.remove(productThree);
        iteration(products);

        //set
        skipPlaceAndTask("Set element in array: ");
        products.set(2, productThree);
        iteration(products);

        //sort
        skipPlaceAndTask("Sorting elements with comparator: ");
        products.sort(new PriceComparator());
        iteration(products);

        //subList
        skipPlaceAndTask("Sublist of products: ");
        List<Product> subList = products.subList(0, 3);
        iteration(subList);

        //clear
        skipPlaceAndTask("Clear a list: ");
        subList.clear();
        iteration(subList);

        //contains
        skipPlaceAndTask("Contains: ");
        if(products.contains(productThree)){
            System.out.println(productThree);
        }

        //isEmpty
        skipPlaceAndTask("Is empty: ");
        if(subList.isEmpty()){
            System.out.println("This array is empty");
        }

        //retainAll
        skipPlaceAndTask("RetainAll: ");
        subList.addAll(products);
        subList.add(productOne);
        products.retainAll(subList);
        iteration(products);

        //size
        skipPlaceAndTask("Array size: ");
        System.out.println(products.size());

        //toArray
        skipPlaceAndTask("To array: ");
        Product[] productsArray = products.toArray(new Product[products.size()]);
        for (Product p : productsArray) {
            System.out.println(p);
        }
    }
}