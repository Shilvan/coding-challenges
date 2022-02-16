# Python Notes

## Functions

### Map:
It applies a function to all the elements of a list (convert it back to a list to get the result).
```
map(function, list)
```
### Filter:
It applies a [true statement](#true-statement) function to a list and create a new list with the elements that satisfy the condition (convert it back to a list to get the result).
```
filter(lambda x: x > 3, list)
```
### Reduce:
It a applies a function that takes two arguments and reduces it to one, keeps on doing it, until the list is reduced to one. For example, getting the total of a list. It has to be imported `From functools import reduce`.
```
reduce(lambda x, y: x + y, list)
```
### Reverse:
It returns a reverse sequence as a "reversed iterator" intended to be used in a loop.
```
"".join(reversed("abc")) #returns "cba"
list(reversed("abc")) #returns ["c", "b", "a"]
```

## Data Types

### Tupples vs Lists:
List occupies more memory, tupples are immutable; they can't change. Tupple declaration is done separating elements by a comma, you can also use brackets to encase the tupple, although not needed: `x = ("a",)` or `x = "a",`.
You can also assign the tupple's elements to variables:
```
age, gender, score = (21, "male", 99)
```


## Other

### Lambda:
Used for unnamed functions that are going to be used once inline.
```
def function(x)
  return x + 2
```
Would produce the same result as:
```
lambda x: x + 2
```
### <a name="true-statement"></a> True statements:
These functions have a Boolean condition as the return value returning either True or False `return x > 3`.
\*You can also have a function that uses an if else statement to return a value `return A+1 if A > B else A-1`.
### Indexing and slicing
```
-3,-2,-1
[a, b, c]
0, 1, 2
```
You can get the first element by `list[0]` or `list[-3]`
#### list[m:n]
Return a portion of the list starting at `m` and going up to and not including `n`.
If one of the values is ommited, it'll either start at the beginning or end at the last position.
#### list[m:n:s]
The third element `s` serves as a step. For example, `list[6:0:-2]` goes backward skipping one element, returning the elements at the position `6,4,2`.
\*`list[::-1]` returns a reversed version of the list.
