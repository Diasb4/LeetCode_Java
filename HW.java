import java.util.*;
import java.util.stream.Collectors;

public class HW {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases for the solution methods
        Integer[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Starting the solution...");
        solution.solve(arr);

        System.out.println("");
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        for (String word : words) {
            solution.Caps(word);
        }

        System.out.println("");
        List<Integer> numbers = Arrays.asList(1, 6, 3, 9, 5, 7, 2);
        solution.countObjects(numbers);
        solution.FirstOver(numbers);

        System.out.println("");
        List<Integer> mixedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        solution.AllPositive(mixedNumbers);

        System.out.println("");
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 54);
        Person person3 = new Person("Charlie", 17);
        solution.SortPeople(Arrays.asList(person1, person2, person3));

        System.out.println("");
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 54),
                new Person("Charlie", 17));
        solution.PrintAge(people);

        System.out.println("");
        solution.GroupByAge(people);

        System.out.println("");
        solution.PrintName(people);

        System.out.println("");
        solution.MiddleAge(people);

        System.out.println("");
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9));
        solution.UnfoldingList(nested);

        System.out.println("");
        List<Integer> uniqueNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        solution.UniqueElements(uniqueNumbers);

        System.out.println("");
        solution.CollectingMap(people);

        System.out.println("");
        List<Integer> partitionNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        solution.Particing(partitionNumbers);

        System.out.println("");
        solution.filterPeople(people, 'A', 18);

        System.out.println("");
        List<String> stringList = Arrays.asList("hello", "world", "java");
        solution.AllAtOnce(stringList);

        System.out.println("");
        List<String> stringList2 = Arrays.asList("short", "medium", "a very long string");
        solution.MaxString(stringList2);

        System.out.println("");
        solution.CountAllChar(stringList);

        System.out.println("");
        solution.FilterLenght(stringList, 4);

        System.out.println("");
        solution.startLetters(stringList);

        System.out.println("");
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        solution.SumOfSquares(intList);

        System.out.println("");
        solution.MultOfNumbers(intList);

        System.out.println("");
        solution.MaxAndMin(intList);

        System.out.println("");
        solution.Statistics(intList);

        System.out.println("");
        solution.FactorialStream(6);

        System.out.println("");
        Product product = new Product("Laptop", 999.99, "Electronics");
        Product product2 = new Product("Phone", 499.99, "Electronics");
        Product product3 = new Product("Book", 19.99, "Literature");
        List<Product> products = Arrays.asList(product, product2, product3);
        solution.MostBigCostInEachCategory(products);

        System.out.println("");
        solution.TopNElements(products, 3);

        System.out.println("");
        solution.FilterEvenSquareSum(intList);

        System.out.println("");
        solution.HardFilter(people);

        System.out.println("");
        String[] stringArray = { "apple", "banana", "kiwi", "grape", "pear" };
        solution.ChainOperations(stringArray);

        System.out.println("");
        List<String> freqList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        solution.FrequencyOfStrings(freqList);
    }
}

class Solution {
    // 1
    public void solve(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.println("Even: " + list.get(i));
            }
        }
    }

    // 2
    public void Caps(String str) {
        System.out.println(str.toUpperCase());
    }

    // 3
    public void countObjects(List<Integer> args) {
        int count = 0;
        for (Integer i : args) {
            if (i > 5) {
                count++;
            }
        }
        System.out.println("Count of Integer objects: " + count);
    }

    // 4
    public void FirstOver(List<Integer> args) {
        if (args.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        for (Integer i : args) {
            if (i > 3) {
                System.out.println("First object over 3: " + i);
                return;
            }
        }
    }

    // 5
    public void AllPositive(List<Integer> args) {
        boolean allPositive = true;
        for (Integer i : args) {
            if (i <= 0) {
                allPositive = false;
                break;
            }
        }
        System.out.println("All objects are positive: " + allPositive);
    }

    // 6
    public void SortPeople(List<Person> people) {
        for (Person person : people) {
            if (person.getAge() > 18) {
                System.out.println("Person is over 18: " + person.getName());
            }
        }
    }

    // 7
    public void PrintAge(List<Person> people) {
        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Sorted people by age:");
        for (Person person : people) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }

    // 8
    public void GroupByAge(List<Person> people) {
        Map<Integer, List<Person>> ageGroups = new HashMap<>();
        for (Person person : people) {
            ageGroups.computeIfAbsent(person.getAge(), k -> new ArrayList<>()).add(person);
        }
        System.out.println("Grouped by age:");
        for (Map.Entry<Integer, List<Person>> entry : ageGroups.entrySet()) {
            System.out.println("Age: " + entry.getKey() + ", People: " + entry.getValue());
        }
    }

    // 9
    public void PrintName(List<Person> people) {
        for (Person p : people) {
            System.out.println("Name: " + p.getName());
        }
    }

    // 10
    public void MiddleAge(List<Person> people) {
        if (people.isEmpty()) {
            System.out.println("No people to evaluate.");
            return;
        }
        people.sort(Comparator.comparingInt(Person::getAge));
        int middleIndex = 0;
        for (Person person : people) {
            middleIndex += person.getAge();
        }
        middleIndex /= people.size();
        System.out.println("Middle age: " + middleIndex);
    }

    // 11
    public void UnfoldingList(List<List<Integer>> args) {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9));

        List<Integer> flat = new ArrayList<>();
        for (List<Integer> inner : nested) {
            flat.addAll(inner);
        }
        System.out.println("Unfolded list: " + flat);
    }

    // 12
    public void UniqueElements(List<Integer> args) {
        Set<Integer> uniqueElements = new HashSet<>(args);
        System.out.println("Unique elements: " + uniqueElements);
    }

    // 13
    public void CollectingMap(List<Person> people) {
        Map<String, Integer> nameToAgeMap = new HashMap<>();
        for (Person person : people) {
            nameToAgeMap.put(person.getName(), person.getAge());
        }
        System.out.println("Name to Age Map: " + nameToAgeMap);
    }

    // 14
    public void Particing(List<Integer> args) {
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer i : args) {
            if (i % 2 == 0) {
                evenNumbers.add(i);
            } else {
                oddNumbers.add(i);
            }
        }
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }

    // 15
    public void filterPeople(List<Person> people, char letter, int minAge) {
        List<Person> result = new ArrayList<>();

        for (Person p : people) {
            if (p.getName().startsWith(String.valueOf(letter)) && p.getAge() > minAge) {
                result.add(p);
            }
        }

        System.out.println("Люди с именем на '" + letter + "' и возрастом > " + minAge + ":");
        for (Person r : result) {
            System.out.println(r);
        }
    }

    // 16
    public void AllAtOnce(List<String> args) {
        StringBuilder result = new StringBuilder();
        for (String s : args) {
            result.append(s.toString()).append(", ");
        }
        System.out.println("All at once: " + result.toString().trim());
    }

    // 17
    public void MaxString(List<String> args) {
        if (args.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        String maxString = args.get(0);
        for (String s : args) {
            if (s.length() > maxString.length()) {
                maxString = s;
            }
        }
        System.out.println("Max string: " + maxString);
    }

    // 18
    public void CountAllChar(List<String> args) {
        int totalChars = 0;
        for (String s : args) {
            totalChars += s.length();
        }
        System.out.println("Total characters: " + totalChars);
    }

    // 19
    public void FilterLenght(List<String> args, int length) {
        List<String> result = new ArrayList<>();
        for (String s : args) {
            if (s.length() > length) {
                result.add(s);
            }
        }
        System.out.println("Strings longer than " + length + ": " + result);
    }

    // 20
    public void startLetters(List<String> args) {
        List<Character> result = new ArrayList<>();
        for (String s : args) {
            result.add(s.charAt(0));
        }
        System.out.println("First letters: " + result);
    }

    // 21
    public void SumOfSquares(List<Integer> args) {
        int sum = 0;
        for (Integer i : args) {
            sum += i * i;
        }
        System.out.println("Sum of squares: " + sum);
    }

    // 22
    public void MultOfNumbers(List<Integer> args) {
        int product = 1;
        for (Integer i : args) {
            product *= i;
        }
        System.out.println("Product of numbers: " + product);
    }

    // 23
    public void MaxAndMin(List<Integer> args) {
        if (args.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        int max = Collections.max(args);
        int min = Collections.min(args);
        System.out.println("Max: " + max + ", Min: " + min);
    }

    // 24
    public void Statistics(List<Integer> numbers) {

        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }

    // 25
    public void FactorialStream(int n) {
        long factorial = java.util.stream.IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }

    // 26
    public void MostBigCostInEachCategory(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Product list is empty.");
            return;
        }
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        System.out.println("Most expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> System.out
                .println("Category: " + category + ", Product: " + product.orElse(null)));
    }

    // 27
    public void TopNElements(List<Product> products, int n) {
        List<Double> topN = products.stream()
                .map(Product::getPrice)
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .collect(Collectors.toList());
        System.out.println("Top " + n + " elements: " + topN);
    }

    // 28
    public void FilterEvenSquareSum(List<Integer> numbers) {
        int sum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num * num)
                .sum();
        System.out.println("Sum of even squares: " + sum);
    }

    // 29
    public void HardFilter(List<Person> people) {
        List<Person> result = people.stream()
                .filter(p -> p.getAge() > 18 && p.getName().startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered people: " + result);
    }

    // 30
    public void ChainOperations(String[] strings) {
        String result = Arrays.stream(strings)
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining(" | "));
        System.out.println(result);
    }

    // 31*
    public void FrequencyOfStrings(List<String> strings) {
        Map<String, Long> frequencyMap = strings.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println("Frequency of each string:");
        frequencyMap.forEach((str, count) -> System.out.println(str + ": " + count));
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

class Product {
    private String name;
    private double price;
    private String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
