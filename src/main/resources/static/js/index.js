console.log('::: INDEX.JS')

const openModal = () => {
    console.log('OPEN MODAL')
}





// DRAG AND DROP

const updateTask = async (taskId, isHighImportance, isHighUrgency) => {

    const postUrl = `/save?taskId=${taskId}`;

    const formData = new FormData();

    formData.append('taskId', taskId);
    formData.append('isHighImportance', isHighImportance);
    formData.append('isHighUrgency', isHighUrgency);
    formData.append('taskText', 'drag-and-drop');

    console.log('FORM DATA', formData)

    const config = {
        headers: {'content-type': 'multipart/form-data'}
    };

    return axios.post(postUrl, formData, config)
    .then( response => {
        return true;
    })
    .catch( error => {
        return false;
    });

};

const dragStart = (event) => {

    // dataset attributes are converted to lowercase (taskId ==> taskid)
    let taskId = event.target.dataset.taskid

    event.dataTransfer.setData("taskId", taskId);
}

const dragEnd = (event) => {
    console.log("DRAG END")
}

const allowDrop = (event) => {
    event.preventDefault();
    console.log("DRAGGING . . .")
}

const drop = (event) => {
    event.preventDefault();
    console.log("TASK ID:", )

    let taskId = event.dataTransfer.getData("taskId")
    let newIsHighImportance = event.target.dataset.ishighimportance === "true";
    let newIsHighUrgency = event.target.dataset.ishighurgency === "true";

    updateTask(taskId, newIsHighImportance, newIsHighUrgency)
    .then( success => {

        console.log('UPDATE SUCCESSFUL?', success)

        if (success) {
            let taskElement = document.getElementById(`task-${taskId}`);
            let parentElement = taskElement.parentElement;
            parentElement.removeChild(taskElement);
            event.target.appendChild(taskElement);
            return;
        }

        console.log('UPDATE FAILED')
    })
}