/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
 var merge = function(intervals) {
    intervals.sort((a,b) => a[0]-b[0]);
    let res = [];

    for(let i = 0; i < intervals.length; i++){
        if(res.length == 0 || res[res.length-1][1] < intervals[i][0]){
            res.push([intervals[i][0],intervals[i][1]]);
        }else if(res[res.length-1][1] < intervals[i][1]){
            res[res.length-1][1] = intervals[i][1];
        }else{
            continue;
        }
    }
    return res;
    
};

