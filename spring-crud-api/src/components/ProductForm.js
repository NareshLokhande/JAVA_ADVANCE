import { useState } from "react"
import { saveProduct } from "../services/ProductService";

export function ProductForm(){

    const [formData, setFormData] = useState({name:'', price:'', quantity:''});

    const handleChange = (e) =>{
        setFormData({...formData,[e.target.name]:e.target.value})
    }

    const handleSubmit = async(e)=>{
        e.preventDefault();
        try {
          const response = await saveProduct(formData);
          console.log(response);
        } catch (error) {
          console.error("Error saving product:", error);
        }

    }

    return (
      <>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={formData.name}
            onChange={handleChange}
          />
          <br />
          <input
            type="text"
            name="price"
            placeholder="Price"
            value={formData.price}
            onChange={handleChange}
          />
          <br />
          <input
            type="text"
            name="quantity"
            placeholder="Quantity"
            value={formData.quantity}
            onChange={handleChange}
          />
          <br />
          <input type="submit" value="Add Product" />
          <br />
        </form>
      </>
    );
}