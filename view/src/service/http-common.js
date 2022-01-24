import axios from "axios";

export default axios.create({
    baseURL: "/expense/api/v1/admin/",
    headers: {
        "Content-type": "application/json"
    }
});