import axios from 'axios';

const api = axios.create({
    baseURL: 'https://flash-car-api.herokuapp.com',
})

export default api;