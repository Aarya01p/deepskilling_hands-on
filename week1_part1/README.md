# Data Structures & Algorithms Hands-on Exercises

This repository contains implementations and analyses for 7 core Data Structures and Algorithms (DSA) exercises, ranging from basic memory representations to advanced searching, sorting, and recursive algorithms.

---

## Table of Contents
1. [Exercise 1: Inventory Management System](#exercise-1-inventory-management-system)
2. [Exercise 2: E-commerce Platform Search Function](#exercise-2-e-commerce-platform-search-function)
3. [Exercise 3: Sorting Customer Orders](#exercise-3-sorting-customer-orders)
4. [Exercise 4: Employee Management System](#exercise-4-employee-management-system)
5. [Exercise 5: Task Management System](#exercise-5-task-management-system)
6. [Exercise 6: Library Management System](#exercise-6-library-management-system)
7. [Exercise 7: Financial Forecasting](#exercise-7-financial-forecasting)
8. [Compilation & Verification](#compilation--verification)
9. [How to Push to GitHub](#how-to-push-to-github)

---

## Exercise 1: Inventory Management System

### Scenario
An inventory management system for a warehouse where products must be stored, updated, retrieved, and deleted efficiently.

### Source Files
- [Product.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise1/Product.java) - Models the product entity.
- [Inventory.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise1/Inventory.java) - Handles additions, updates, deletions, and lookups using a Hash Map.
- [Main.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise1/Main.java) - Driver program demonstrating execution.

### Theoretical Understanding
1. **Importance of DSA in Inventory Management**: 
   In large warehouses with millions of items, sequential search or inefficient data storage results in high operational latency. Choosing optimal data structures guarantees that search, update, and deletion operations complete in constant time ($O(1)$), keeping systems responsive.
2. **Suitable Data Structures**:
   - **ArrayList**: Good for traversal but poor for retrieval by non-index keys ($O(n)$ search time) and deletion ($O(n)$ shifting overhead).
   - **HashMap (Chosen)**: Key-value mapping of `productId` $\rightarrow$ `Product`. Offers average $O(1)$ lookup, addition, and deletion.
   - **TreeMap**: Useful if products must be kept sorted by key, though operations degrade to $O(\log n)$.

### Complexity Analysis
For the chosen **HashMap**:
| Operation | Average Case | Worst Case | Description |
| :--- | :--- | :--- | :--- |
| **Add** | $O(1)$ | $O(n)$ | Direct insertion. Worst case happens during severe hash collisions. |
| **Update** | $O(1)$ | $O(n)$ | Direct key retrieval and updating attributes in-place. |
| **Delete** | $O(1)$ | $O(n)$ | Direct key removal from the hash table bucket. |

#### Optimizations
- Set an appropriate **initial capacity** and **load factor** to avoid frequent rehashing.
- Design a high-quality hash function to minimize hash collisions.

---

## Exercise 2: E-commerce Platform Search Function

### Scenario
Optimizing search functionality of an e-commerce platform for fast performance using linear and binary search algorithms.

### Source Files
- [Product.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise2/Product.java) - Models product attributes (`productId`, `productName`, `category`) and implements `Comparable`.
- [Search.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise2/Search.java) - Contains linear and binary search implementations.
- [Main.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise2/Main.java) - Demonstrates searching on sorted and unsorted arrays.

### Theoretical Understanding
1. **Asymptotic Notation (Big O)**:
   Big O notation defines the upper bound of an algorithm's growth rate in terms of execution time or space complexity as the input size ($n$) grows. It helps engineers compare algorithms independently of hardware configurations.
2. **Search Scenarios**:
   - **Linear Search**: Checks elements sequentially.
     - *Best Case*: $O(1)$ (target is at index 0).
     - *Average / Worst Case*: $O(n)$ (target is at the end or not present).
   - **Binary Search**: Repeatedly halves the search space.
     - *Best Case*: $O(1)$ (target is at the midpoint).
     - *Average / Worst Case*: $O(\log n)$ (target is found after repeatedly dividing space).

### Complexity Analysis
| Algorithm | Best Case | Average Case | Worst Case | Space Complexity | Requires Sorted Input? |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Linear Search** | $O(1)$ | $O(n)$ | $O(n)$ | $O(1)$ | No |
| **Binary Search** | $O(1)$ | $O(\log n)$ | $O(\log n)$ | $O(1)$ | Yes |

#### Platform Recommendation
For an e-commerce search page, **Binary Search** (or index-based hashing) is far more suitable due to its logarithmic time growth. However, because binary search requires sorted data, we should maintain a sorted list in memory or database indexes rather than sorting the array prior to every single search query (since sorting takes $O(n \log n)$).

---

## Exercise 3: Sorting Customer Orders

### Scenario
Sorting customer orders by their total price on an e-commerce platform to prioritize high-value transactions.

### Source Files
- [Order.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise3/Order.java) - Represents customer order with `totalPrice`.
- [Sorting.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise3/Sorting.java) - Implements Bubble Sort and Quick Sort algorithms.
- [Main.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise3/Main.java) - Executes and compares sorting outputs.

### Theoretical Understanding
- **Bubble Sort**: Simple comparison-based algorithm. Compares adjacent elements and swaps them. $O(n^2)$ time complexity.
- **Insertion Sort**: Inserts elements one-by-one into their sorted position. Excellent for small or nearly sorted lists ($O(n)$ best case).
- **Quick Sort**: Divide-and-conquer algorithm. Selects a pivot and partitions elements such that items smaller than the pivot are on the left, and larger are on the right.
- **Merge Sort**: Stable divide-and-conquer algorithm. Divides the array in half, sorts them, and merges them. Always takes $O(n \log n)$ but requires $O(n)$ auxiliary space.

### Complexity Analysis
| Sorting Algorithm | Best Case | Average Case | Worst Case | Space Complexity | Stable? |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Bubble Sort** | $O(n)$ | $O(n^2)$ | $O(n^2)$ | $O(1)$ | Yes |
| **Quick Sort** | $O(n \log n)$ | $O(n \log n)$ | $O(n^2)$ | $O(\log n)$ | No |

#### Why Quick Sort is Preferred
1. **In-place sorting**: Unlike Merge Sort, Quick Sort does not require $O(n)$ extra memory.
2. **Practical speed**: It has lower constant factors than Merge Sort and Heap Sort, making it faster in practice on real-world datasets.
3. **Cache Friendliness**: It accesses array elements sequentially during partitioning, aligning well with modern CPU cache architectures.

---

## Exercise 4: Employee Management System

### Scenario
Efficiently managing employee records utilizing contiguous memory structures.

### Source Files
- [Employee.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise4/Employee.java) - Models the employee record.
- [EmployeeManager.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise4/EmployeeManager.java) - Implements contiguous array storage, dynamic resizing, lookups, and deletions.
- [Main.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise4/Main.java) - Demonstrates array manipulation.

### Theoretical Understanding
1. **Array Representation in Memory**:
   Arrays are stored in contiguous memory locations. The address of an element at index $i$ is computed mathematically in $O(1)$ time:
   $$\text{Address}(A[i]) = \text{BaseAddress} + (i \times \text{SizeOfElement})$$
2. **Advantages**:
   - Immediate random access ($O(1)$ lookup if index is known).
   - Minimal memory overhead (no pointers/node structures).

### Complexity Analysis
| Operation | Time Complexity | Reason |
| :--- | :--- | :--- |
| **Add** | $O(1)$ (amortized) | Adding to the end is $O(1)$. If capacity is exceeded, resizing requires copying all elements, taking $O(n)$. |
| **Search** | $O(n)$ | Must scan the array sequentially to match `employeeId`. |
| **Traverse** | $O(n)$ | Must visit every cell up to the current size. |
| **Delete** | $O(n)$ | Finding the element takes $O(n)$. Shifting remaining elements to fill the gap to maintain contiguity takes $O(n)$. |

#### Limitations
- Fixed size upon initialization.
- Insertion and deletion in the middle are expensive ($O(n)$).
- Use arrays only when the database size is mostly static and random index access is primary.

---

## Exercise 5: Task Management System

### Scenario
A task management tool requiring frequent, dynamic additions and deletions.

### Source Files
- [Task.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise5/Task.java) - Models the task node.
- [TaskList.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise5/TaskList.java) - Singly linked list with addition, search, traversal, and deletion.
- [Main.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise5/Main.java) - Runs task manipulations.

### Theoretical Understanding
1. **Linked List Types**:
   - **Singly Linked List**: Each node contains data and a pointer to the *next* node.
   - **Doubly Linked List**: Each node contains pointers to both the *next* and *previous* nodes, facilitating bidirectional traversals at the cost of extra memory pointer overhead.

### Complexity Analysis
| Operation | Time Complexity | Reason |
| :--- | :--- | :--- |
| **Add** | $O(n)$ | We traverse to the end of the list to append. (Would be $O(1)$ if we maintained a `tail` pointer). |
| **Search** | $O(n)$ | Sequential traversal from the `head` pointer. |
| **Traverse** | $O(n)$ | Must visit each node in the list. |
| **Delete** | $O(n)$ | Searching for the node takes $O(n)$. Once found, splicing the pointer is $O(1)$. |

#### Advantages of Linked Lists over Arrays
- Dynamic size allocation (grows and shrinks without expensive array copies).
- Insertions and deletions do not require shifting elements, making updates highly efficient when node references are already available.

---

## Exercise 6: Library Management System

### Scenario
Searching for books by title in a library management system using sorted and unsorted collections.

### Source Files
- [Book.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise6/Book.java) - Models book records and implements `Comparable` by title.
- [Library.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise6/Library.java) - Contains linear search and binary search.
- [Main.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise6/Main.java) - Driver program sorting and searching.

### Theoretical Understanding
- **Linear Search**: Scans array element-by-element. Works on any dataset size and does not require sorting.
- **Binary Search**: Divides sorted dataset in half iteratively. Requires sorted inputs.

### Complexity Analysis
- **Linear Search**: $O(n)$ time complexity.
- **Binary Search**: $O(\log n)$ time complexity.

#### Decision Matrix
- Use **Linear Search** for small collections or highly volatile datasets where the overhead of sorting ($O(n \log n)$) exceeds the savings of logarithmic search.
- Use **Binary Search** for large, static datasets where database queries/lookups happen frequently.

---

## Exercise 7: Financial Forecasting

### Scenario
Predicting future values based on past growth rates using recursive functions.

### Source Files
- [FinancialForecasting.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise7/FinancialForecasting.java) - Implements recursive and iterative calculations.
- [Main.java](file:///C:/Users/seetech/.gemini/antigravity/scratch/dsa-hands-on/src/exercise7/Main.java) - Executes predictions and prints growth forecasts.

### Theoretical Understanding
- **Recursion**: A programming technique where a method calls itself to solve smaller subproblems until it hits a base case. Recursion simplifies complex problems like tree traversals, fractal calculations, and dynamic programming formulations.

### Complexity Analysis
- **Recursive Algorithm**:
  - **Time Complexity**: $O(n)$ where $n$ is the number of years forecast.
  - **Space Complexity**: $O(n)$ due to call stack overhead.

#### Optimization
To avoid stack overflow errors on long forecasting timelines, we optimized the recursion by implementing an **Iterative Algorithm**:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ (constant space, eliminating stack frames).

---

## Compilation & Verification

You can easily compile and run all the exercises using the provided Windows batch script.

1. Open PowerShell or Command Prompt.
2. Navigate to the project directory:
   ```cmd
   cd C:\Users\seetech\.gemini\antigravity\scratch\dsa-hands-on
   ```
3. Run the verification script:
   ```cmd
   .\compile_and_run.bat
   ```

---

## How to Push to GitHub

To push this repository to your GitHub repository at `https://github.com/Aarya01p/deepskilling_hands-on`, follow these step-by-step instructions.

### Prerequisites
Make sure you have Git installed on your system. If not, download it from [git-scm.com](https://git-scm.com/).

### Steps

#### 1. Open Terminal/PowerShell
Open PowerShell and navigate to the project directory:
```powershell
cd C:\Users\seetech\.gemini\antigravity\scratch\dsa-hands-on
```

#### 2. Initialize Git Repository
If you haven't already, initialize the directory as a Git repository:
```powershell
git init
```

#### 3. Add Files to Staging
Stage all files including Java source code, batch scripts, and the README file:
```powershell
git add .
```

#### 4. Commit the Changes
Commit the staged files with an informative message:
```powershell
git commit -m "Initialize repository: Complete 7 DSA hands-on exercises in Java"
```

#### 5. Configure Remote Origin
Link your local repository to your remote GitHub repository:
```powershell
git remote add origin https://github.com/Aarya01p/deepskilling_hands-on.git
```

*Note: If the remote already exists, you can update it using:*
```powershell
git remote set-url origin https://github.com/Aarya01p/deepskilling_hands-on.git
```

#### 6. Rename Default Branch to `main`
Ensure your local branch is named `main` (which matches GitHub's default naming convention):
```powershell
git branch -M main
```

#### 7. Push to GitHub
Push the committed changes to the remote repository. 
```powershell
git push -u origin main
```
*Note: If prompted, authenticate using your GitHub username/password or a Personal Access Token (PAT).*
