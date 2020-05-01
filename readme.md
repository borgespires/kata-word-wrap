# Word Wrap

[1]: https://blog.cleancoder.com/uncle-bob/2013/05/27/TheTransformationPriorityPremise.html
[2]: http://thecleancoder.blogspot.com/2010/10/craftsman-62-dark-path.html

## The Transformation Priority Premise
- [The Transformation Priority Premise by Uncle Bob][1]
- [The Craftsman 62, The Dark Path][2]

### Transformations
1. ({}–>nil) no code at all->code that employs nil
2. (nil->constant)
3. (constant->constant+) a simple constant to a more complex constant
4. (constant->scalar) replacing a constant with a variable or an argument
5. (statement->statements) adding more unconditional statements.
6. (unconditional->if) splitting the execution path
7. (scalar->array)
8. (array->container)
9. (statement->recursion)
10. (if->while)
11. (expression->function) replacing an expression with a function or algorithm
12. (variable->assignment) replacing the value of a variable.

### Process
If we accept the Priority Premise, then we should amend the typical red-green-refactor process of TDD with the following provision:

- When passing a test, prefer higher priority transformations.
- When posing a test choose one that can be passed with higher priority transformations.
- When an implementation seems to require a low priority transformation, backtrack to see if there is a simpler test to pass.