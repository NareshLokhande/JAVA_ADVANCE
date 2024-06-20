import { useState } from "react";
import { saveProduct } from "../services/ProductService";

export function ProductForm() {
  const [formData, setFormData] = useState({
    name: "",
    price: "",
    quantity: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };
  
  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await saveProduct(formData);
    console.log(response);
  };

  return (
    <>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="name"
          onChange={handleChange}
        />
        <input
          type="text"
          name="price"
          placeholder="price"
          onChange={handleChange}
        />
        <input
          type="text"
          name="quantity"
          placeholder="quantity"
          onChange={handleChange}
        />
        <input type="submit" value="Add Product" />
      </form>
    </>
  );
}
