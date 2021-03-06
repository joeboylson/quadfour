// INDEX.JS

// PASSWORD CONFIRMATION

const handleChange = () => {
    console.log('HANDLE CHANGE')

    let passwordField = document.getElementById("password");
    let confirmPasswordField = document.getElementById("confirm-password");

    if (!passwordField || !confirmPasswordField) {
        return console.log('FIELDS NOT AVAILABLE')
    }

    console.log(
        passwordField.value,
        confirmPasswordField.value
    )
}



// DRAG AND DROP

const updateTask = async (taskId, taskText, isHighImportance, isHighUrgency) => {

    const postUrl = `/save?taskId=${taskId}`;
    const formData = new FormData();

    formData.append('taskId', taskId);
    formData.append('isHighImportance', isHighImportance);
    formData.append('isHighUrgency', isHighUrgency);
    formData.append('taskText', taskText);

    const config = { headers: {'content-type': 'multipart/form-data'} };
    return axios.post(postUrl, formData, config)
    .then( response => {
        return true;
    }).catch( error => {
        return false;
    });

};

const removeAllDraggingOverClass = () => {
    let elements = document.getElementsByClassName('dragging-over');
    for (let element of elements) {
        element.classList.remove('dragging-over');
    }
}

const dragStart = (event) => {

    // dataset attributes are converted to lowercase (taskId ==> taskid)
    let taskId = event.target.dataset.taskid
    let taskText = event.target.dataset.tasktext

    event.dataTransfer.setData("taskId", taskId);
    event.dataTransfer.setData("taskText", taskText);

}

const dragEnd = (event) => {
    removeAllDraggingOverClass();
}

const allowDrop = (event) => {
    event.preventDefault();
    const hasDraggingOverClass = event.target.classList.contains('dragging-over');

    if (!hasDraggingOverClass) {
        removeAllDraggingOverClass();

        // if hovering over a task element, add class to parent
        if (event.target.classList.contains('quadrant-list-item')) {
            return event.target.parentElement.classList.add('dragging-over')
        }

        return event.target.classList.add('dragging-over')
    }
}

const drop = (event) => {
    event.preventDefault();

    let taskId = event.dataTransfer.getData("taskId");
    let taskText = event.dataTransfer.getData("taskText");
    let newIsHighImportance = event.target.dataset.ishighimportance === "true";
    let newIsHighUrgency = event.target.dataset.ishighurgency === "true";

    updateTask(taskId, taskText, newIsHighImportance, newIsHighUrgency)
    .then( success => {

        if (success) {
            let taskElement = document.getElementById(`task-${taskId}`);
            let parentElement = taskElement.parentElement;
            parentElement.removeChild(taskElement);
            event.target.appendChild(taskElement);
            return;
        }
    })
}