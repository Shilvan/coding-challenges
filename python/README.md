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
It a applies a function that takes two arguments and reduces it to one, keeps on doing it, until the list is reduced to one. For example, getting the total of a list. It has to be imported:
```
From functools import reduce
reduce(lambda x, y: x + y, list)
```
### Reverse:
It returns a reverse sequence as a "reversed iterator" intended to be used in a loop.
```
"".join(reversed("abc")) #returns "cba"
list(reversed("abc")) #returns ["c", "b", "a"]
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
These functions have a Boolean condition as the return value returning either True or False
```
return x > 3
```
\*You can also have a function that uses an if else statement to return a value
```
return A+1 if A > B else A-1
```
