package se.lexicon.g58todoapp.controller;

public class TodoController {

    //TODO: Implement basic CRUD operations for Todo entity

    //localhost:8080/api/people for all the endpoint in this class.



        private final TodoRepository todoRepository;

        public TodoController(TodoRepository todoRepository){
            this.todoRepository= todoRepository;

        }

        @GetMapping("/{id}")
        public Todo getTodoId(@PathVariable Long id){
            return todoRepository.findById(id).orElseThrow(RuntimeException::new);
        }
        //POST
        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping
        public void createTodo(@RequestBody Todo todo){
            todoRepository.save(todo);
        }
        //DELETE
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteTodo(@PathVariable Long id){
            todoRepository.deleteById(id);
        }



        //RequestParam = ?name=Simon
        //GET localhost:8080/api/hello?name=Simon
        @RequestMapping(value = "/hello")
        public String hello (@RequestParam(defaultValue = "from PersonController!") String name) {
            return "Hello, " + name;
        }


}
