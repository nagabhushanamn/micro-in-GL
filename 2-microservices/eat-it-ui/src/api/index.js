
import axios from 'axios';

const baseUrl = ''

const api = {
    loadItems() {
        return axios.get(`${'http://localhost:8081'}/items`)
    },
    loadReviews(itemId) {
        return axios.get(`${'http://localhost:8083'}/reviews/search/findByItemId?itemId=${itemId}`)
    },
    addNewReview(itemId, review) {
        review.itemId = itemId
        return axios.post(`${'http://localhost:8083'}/reviews`, review)
    },
    doLogin(email, password) {
        return axios.post(`${baseUrl}/Users/login`, { email, password })
    },
    buy(cartId,cartLine){
        return axios.post(`${'http://localhost:8083'}/cart/${cartId}`, cartLine)
    },
    loadCart(cartId){
        return axios.get(`${'http://localhost:8083'}/cart/${cartId}`)
    },
    checkout(cartId){
        return axios.post(`${'http://localhost:8084'}/checkout/${cartId}`)
    }
}

export default api;

