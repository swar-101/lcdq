# LeetCode Daily Questions (LCDQ) - Maven Project

This is a Maven-based project for efficiently managing LeetCode Daily Question solutions with multiple versions and comprehensive testing.

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)

### Build and Test
```bash
# Build the project
mvn clean compile

# Run all tests
mvn test

# Build and package
mvn clean package

# Using Maven wrapper (recommended)
./mvnw clean test    # Linux/Mac
mvnw.cmd clean test  # Windows
```

## 📁 Clear Directory Structure (No Ambiguity!)

```
src/
├── solutions/com/leetcode/     # 📂 Main source code (clear naming!)
│   ├── problem0165/            # 165. Compare Version Numbers
│   │   ├── v1/Solution.java
│   │   └── v2/Solution.java
│   ├── problem1912/            # 1912. Design Movie Rental System
│   │   └── v1/MovieRentingSystem.java
│   └── problem3005/            # 3005. Count Elements with Max Frequency
│       ├── v1/Solution.java
│       └── v2/Solution.java
└── tests/com/leetcode/         # 🧪 Test code (clear naming!)
    ├── problem0165/
    │   ├── v1/SolutionTest.java
    │   └── v2/SolutionTest.java
    ├── problem1912/
    │   └── v1/MovieRentingSystemTest.java
    └── problem3005/
        ├── v1/SolutionTest.java
        └── v2/SolutionTest.java
```

**✅ No More Ambiguity!**
- `src/solutions/` - Contains all your LeetCode solutions
- `src/tests/` - Contains all test files
- No confusing `java/` subdirectories!

## 🏗️ Naming Convention

### Package Structure
- **Base package**: `com.leetcode`
- **Problem package**: `problem{XXXX}` (4-digit padded problem number)
- **Version package**: `v1`, `v2`, `v3`, etc.

### File Naming
- **Solution classes**: `Solution.java` or `{ProblemName}.java` (for design problems)
- **Test classes**: `SolutionTest.java` or `{ProblemName}Test.java`

## 📋 Problems Included

### Problem 0165 - Compare Version Numbers
- **v1**: Manual string parsing with arrays
- **v2**: Optimized using String.split() method

### Problem 1912 - Design Movie Rental System  
- **v1**: TreeSet-based implementation for efficient sorting

### Problem 3005 - Count Elements with Max Frequency
- **v1**: Two-pass solution (find max, then count)
- **v2**: Optimized single-pass solution

## 🧪 Testing with Maven

### Running Tests
```bash
# Run all tests
mvn test

# Run tests for specific problem
mvn test -Dtest="com.leetcode.problem0165.*"

# Run specific test class
mvn test -Dtest="SolutionTest"

# Run tests with coverage
mvn test jacoco:report

# Skip tests during build
mvn clean package -DskipTests
```

### Maven Profiles
- **development** (default): Runs all tests
- **quick-build**: Skips tests for faster builds
  ```bash
  mvn clean package -Pquick-build
  ```

## 🔧 Maven Dependencies

The project includes:
- **JUnit 5**: For comprehensive testing
- **Maven Surefire Plugin**: For test execution
- **Maven Compiler Plugin**: Java 17 compilation

## 🚀 Usage

### Running Tests
```bash
# Run all tests
./gradlew test

# Run tests for specific problem
./gradlew test --tests "com.leetcode.problem0165.*"

# Run tests for specific version
./gradlew test --tests "com.leetcode.problem0165.v1.*"
```

### Adding New Problems (Maven)

1. Create solution class: `src/main/java/com/leetcode/problem{XXXX}/v1/Solution.java`
2. Create test class: `src/test/java/com/leetcode/problem{XXXX}/v1/SolutionTest.java`
3. Run tests: `mvn test -Dtest="com.leetcode.problem{XXXX}.*"`
4. Build: `mvn clean compile`

## 📦 Maven Commands Reference

```bash
# Clean build artifacts
mvn clean

# Compile source code
mvn compile

# Run tests
mvn test

# Package JAR
mvn package

# Install to local repository
mvn install

# Generate site documentation
mvn site

# Dependency analysis
mvn dependency:tree
mvn dependency:analyze
```

## 📝 Version Management

Each version represents:
- **v1**: Initial working solution
- **v2**: Optimized or alternative approach
- **v3**: Further optimizations or different algorithms

## 🔧 Migration from Old Structure

The old disorganized structure has been replaced with this standardized approach. The old directories can be safely removed after verifying the migration:

- `165-compare-version-numbers/` → `src/main/java/com/leetcode/problem0165/`
- `1912-design-movie-rental-system/` → `src/main/java/com/leetcode/problem1912/`
- `3005-count-elements-with-max-frequency/` → `src/main/java/com/leetcode/problem3005/`

## 🎯 Best Practices

1. **Consistent Naming**: Always use 4-digit padded problem numbers
2. **Comprehensive Testing**: Include edge cases and performance tests
3. **Documentation**: Add comments explaining the approach in each version
4. **Version Control**: Use meaningful version descriptions in comments
5. **Package Organization**: Keep related code together in version-specific packages

## 📈 Benefits of This Structure

- **Scalability**: Easy to add new problems and versions
- **Organization**: Clear separation of concerns
- **Testing**: Comprehensive test coverage
- **Navigation**: Intuitive directory structure
- **Maintenance**: Easy to find and update specific solutions
