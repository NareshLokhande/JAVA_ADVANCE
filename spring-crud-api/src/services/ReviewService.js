import axios from "axios";

export function saveReview(productId, review) {
  return axios.post(
    `http://localhost:8080/reviews/product/${productId}`,
    review
  );
}

export function getAllReviewsByProductId(productId) {
  return axios.get(
    `http://localhost:8080/reviews/product/${productId}`,
    reviews
  );
}
