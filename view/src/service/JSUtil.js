const setAll = (obj,val) => {
    Object.keys(obj).forEach(k => obj[k] = val);
    return obj;
}

export {setAll}