/**
 * @param {string[]} strs
 * @return {string[][]}
 */
//通过建立哈希表进行
 var groupAnagrams = function(strs) {
    const map = new Map();
    for(let str of strs){
        let arr = str.split("");
        arr.sort();
        let newStr = arr.toString();

        let list = map.get(newStr) ? map.get(newStr) : new Array();
        list.push(str); 
        map.set(newStr,list);
    }
    return Array.from(map.values());
};