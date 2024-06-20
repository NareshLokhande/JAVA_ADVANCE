import { useEffect, useState } from "react";
import { getAllProducts, removeProduct } from "../services/ProductService";

export function ProductsList() {
  
  const [productsList, setProductsList] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");

  async function fetchProducts() {
    try {
      const response = await getAllProducts();
      if (response.status === 200) {
        console.log(response.data.products);
        setProductsList(response.data.products);
      }
    } catch (error) {
      if (error.response.status === 404) {
        console.log(error);
        setProductsList([]);
        setErrorMessage(error.response.data.message);
      }
    }
  }

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <>
      <h1>List of products</h1>
      {
        productsList.length !== 0 ? (
          <table border={1} cellPadding={10} cellSpacing={0}>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Price</th>
              <th>Quantity</th>
              <th>Action</th>
            </tr>
            { 
            productsList.map((product) => {
              return (
                <tr>
                  <td>{product.id}</td>
                  <td>{product.name}</td>
                  <td>Rs. {product.price}</td>
                  <td>{product.quantity}</td>
                  <td><input type="button" value="Delete"
                    onClick={async () => {
                      await removeProduct(product.id);
                      fetchProducts();
                    }}
                  ></input></td>
                </tr>
              );
            })}
          </table>) : ( <h5>{errorMessage}</h5> )}
    </>
  );
}
