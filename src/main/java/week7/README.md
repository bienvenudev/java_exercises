# Functional programming exercises
- Avoid using loops
- Try to use functional programming features in java as much as possible
# Exercise 1:  Student Filtering Pipeline
You are given a list of students. Each student has:
- a name
- an age
- an average grade

Your goal is to process the students.

### Given data
```java
List<Student> students = List.of(  
	new Student("Alice", 22, 85.5),  
	new Student("Bob", 19, 72.0),  
	new Student("Charlie", 25, 10.2),  
	new Student("David", 20, 68.4),  
	new Student("Emma", 23, 88.8),  
	new Student("Frank", 18, 95.1),
	new Student("Nadia", 28, 45.1),
	new Student("Cecile", 20, 99.4),
	new Student("Jack", 32, 50.1) 
);
```

### Tasks
1. Create the Student class
2. Create a list of students
3. Keep only students older than 20
4. Keep only students with a grade greater than 80
5. Sort the students by grade from highest to lowest
6. Convert the student names to uppercase
7. Collect the final names into a `List<String>` studentNames
8. display studentNames

# Exercise 2: Product Inventory Processing
You are given a list of products in an online store. Each product has:
- a name
- a category
- a price
- a stock quantity
Your goal is to generate a list of premium products that are currently available.

### Given data
```java
List<Product> products = List.of(  
	new Product("Laptop", "Electronics", 1200, 5),  
	new Product("Mouse", "Electronics", 25, 50),  
	new Product("Desk", "Furniture", 300, 0),  
	new Product("Phone", "Electronics", 800, 12),  
	new Product("Chair", "Furniture", 150, 7),  
	new Product("Monitor", "Electronics", 400, 3),  
	new Product("Notebook", "Stationery", 10, 100)  
);
```

### Task
1. Keep only products that are in stock
2. Keep only products from the `"Electronics"` category
3. Keep only products with a price greater than `300`
4. Sort the products by price from lowest to highest
5. Convert the products into strings using this format:

```
PRODUCT_NAME -> $PRICE
```

Example:

```
Laptop -> $1200.0
```

6. Collect the final result into a `List<String>` result
7. print the result

# Exercise 3:  Movie Recommendation Processing
You are building a simple movie recommendation feature. Each movie has:
- a title
- a genre
- a rating
- a release year
Your goal is to generate a list of highly rated recent movies.

### Given data
```java
List<Movie> movies = List.of(  
	new Movie("Inception", "Sci-Fi", 8.8, 2010),  
	new Movie("Interstellar", "Sci-Fi", 8.6, 2014),  
	new Movie("The Batman", "Action", 7.9, 2022),  
	new Movie("Dune", "Sci-Fi", 8.1, 2021),  
	new Movie("Joker", "Drama", 8.4, 2019),  
	new Movie("Avengers Endgame", "Action", 8.4, 2019),  
	new Movie("Tenet", "Sci-Fi", 7.3, 2020)  
);
```

### Tasks
1. Keep only movies released after 2015
2. Keep only movies with a rating greater than or equal to `8.0`
3. Sort the movies by rating from highest to lowest
4. Transform each movie into this format:

```
TITLE (YEAR) - RATING
```

Example:

```
Dune (2021) - 8.1
```

5. Collect the final result into a `List<String>` result
6. print result

# Exercise 4: Course Enrollment Analysis
You are given a list of students enrolled in an online course platform. Each student has:
- a name
- a course
- a completion percentage
Your task is to analyze the data

### Given Data

```java
List<Student> students = List.of(
	new Student("Alice", "Java", 100),
	new Student("Bob", "Java", 75),
	new Student("Charlie", "Python", 40),
	new Student("David", "Java", 90),
	new Student("Emma", "Python", 100),
	new Student("Frank", "JavaScript", 20)
);
```

### Tasks
- Count how many students:
	- are enrolled in the `"Java"` course
	- have completed the course (`progress == 100`)
- Check if:
	- At least one student has `0%` progress
	- All students have progress greater than `10`
	- No student has progress below `0`
	- Store each result in a boolean variable.
- Find:
	- The first student who completed a course
	- Any student enrolled in `"Python"`
	- Store results in `Optional<Student>` variables.
- Print the result of the operations above

# Exercise 5: Sales Report
You are given a list of customer orders from an online store. Each order has:
- a customer name
- a total amount
- a payment status
Your goal is to generate sales statistics

### Given data
```java
List<Order> orders = List.of(  
	new Order("Alice", 120.50, true),  
	new Order("Bob", 75.00, false),  
	new Order("Charlie", 210.30, true),  
	new Order("David", 99.99, true),  
	new Order("Emma", 180.00, false),  
	new Order("Frank", 320.40, true)  
);
```

### Tasks
- Calculate the total amount of:
	- all orders
	- only paid orders
	- Store the results in `double` variables.
- Find the order with the highest amount.
- Build a Summary String
	- Create a single string containing all customer names separated by commas.
	- Expected format: **Alice, Bob, Charlie, David, Emma, Frank**
