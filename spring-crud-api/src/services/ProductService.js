import axios from "axios";

export function saveProduct(product){
    return axios.post('http://localhotst:8080/products/',product);
}

export function getAllProducts() {
  return axios.get('http://localhotst:8080/products/');
}

export function removeProduct(id) {
  return axios.get(`http://localhotst:8080/products/{id}`);
}