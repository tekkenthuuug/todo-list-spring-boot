const addTodoForm = document.getElementById("add-todo-form");
const todosContainer = document.getElementById("todos-container");
const todoNameInput = addTodoForm.getElementsByClassName("input")[0];
const todos = todosContainer.getElementsByClassName("todo-card");

const API_BASE_URL = "http://localhost:8000/api";

// helpers
const fetchAndJson = async (input, init) => {
    const response = await fetch(input, init);

    return await response.json();
}

// requests
const deleteTodoItemRequest = async (todoId) => {
    return await fetchAndJson(`${API_BASE_URL}/task/${todoId}`, {method: 'DELETE'});
}

const completeTodoItemRequest = async (todoId) => {
    return await fetchAndJson(`${API_BASE_URL}/task/complete/${todoId}`, {method: 'PUT'});
}

const createTodoItemRequest = async (name) => {
    return await fetchAndJson(`${API_BASE_URL}/task/create`,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name})
        });
}

// send delete request to back-end and if success remove todoItem from DOM
const deleteTodoItem = async (todoElement) => {
    const data = await deleteTodoItemRequest(todoElement.id);

    if (data === true) {
        todoElement.remove();
    } else {
        // TODO: handle error
    }
}

// send update isComplete request to back-end and update with received value
const completeTodoItem = async (todoElement) => {
    const data = await completeTodoItemRequest(todoElement.id);

    if (data === true) {
        todoElement.getElementsByClassName("todo-name")[0].classList.add("todo-done");
    } else {
        todoElement.getElementsByClassName("todo-name")[0].classList.remove("todo-done");
    }
}

// add todoItem to DOM
const addTodoItemToDOM = (todo) => {
    const container = document.createElement("div");
    const content = document.createElement("div");
    const h1 = document.createElement("h1");
    const button = document.createElement("button");

    container.id = todo.id;

    container.className = "card my-4 p-2";
    content.className = "card-content is-flex is-justify-content-space-between is-align-items-center";
    button.className = "delete is-danger todo-delete";

    h1.innerText = todo.name;

    button.addEventListener('click', () => deleteTodoItem(container))

    content.appendChild(h1);
    content.appendChild(button);
    container.appendChild(content);

    todosContainer.prepend(container);
}

// add eventListeners to delete buttons of todoItems
for (let i = 0; i < todos.length; i++) {
    const currentTodo = todos[i];

    currentTodo.getElementsByClassName("todo-delete")[0].addEventListener('click', () => deleteTodoItem(currentTodo));
    currentTodo.getElementsByClassName("todo-name")[0].addEventListener('click', () => completeTodoItem(currentTodo));
}

addTodoForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = await createTodoItemRequest(todoNameInput.value);

    addTodoItemToDOM(data);

    e.target.reset();
})