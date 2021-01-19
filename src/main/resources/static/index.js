const addTodoForm = document.getElementById("add-todo-form");
const todosContainer = document.getElementById("todos-container");
const todoNameInput = addTodoForm.getElementsByClassName("input")[0];
const todos = todosContainer.getElementsByClassName("todo-card");

const API_BASE_URL = "http://localhost:8000/api";

const addTodoItemToDOM = (todo) => {
    const container = document.createElement("div");
    const content = document.createElement("div");
    const h1 = document.createElement("h1");
    const button = document.createElement("button");

    container.id = todo.id;

    container.className = "card my-4 p-2";
    content.className = "card-content is-flex is-justify-content-space-between is-align-items-center";
    button.className = "delete is-danger";

    h1.innerText = todo.name;

    content.appendChild(h1);
    content.appendChild(button);
    container.appendChild(content);

    todosContainer.prepend(container);
}

addTodoForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const response = await fetch(`${API_BASE_URL}/task/create`,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: todoNameInput.value})
        });

    const data = await response.json();

    addTodoItemToDOM(data);

    e.target.reset();
})