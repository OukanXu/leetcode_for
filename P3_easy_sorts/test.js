function select(arr){
    for(let i = 0; i < arr.length-1; i++){
        let min = i;
        for(let j = i+1; j< arr.length; j++){
            if(arr[min] > arr[j]){
                min = j;
            }
        }
        let temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }
    return arr;
}


function bubble(arr){
    for(let i = 0; i < arr.length-1; i++){
        for(let j = 0; j < arr.length; j++){
            if(arr[j+1] < arr[j]){
                let temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}


function insert(arr){
    for(let i = 1; i < arr.length; i++){
        for(let j = i; j>1 && j < arr.length; j--){
            if(arr[j]< arr[j-1]){
                let temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
    return arr;
}


console.log(-1%3);

