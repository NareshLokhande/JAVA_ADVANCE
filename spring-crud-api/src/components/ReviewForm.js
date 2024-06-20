import { useState } from "react";

export function ReviewForm() {
  const [productsList, setproductsList] = useState([]);
  const [formData, setFormData] = useState({content:});
  
  return (
    <>
      <form>
          {
            productsList.length !==0 ? 
            <select name="productId">
              {
                productsList.map((product, index) => {
                  return (
                    <option value={{product.id}>{product.name}}> </option>
                  )
                })
              }
            </select>
          }

        <textarea name="content" placeholder="Review"></textarea>
        <input type="text" name="reviewGivenBy" placeholder="name"
        ></input>
        
        <input type="submit" value="Post Review" disabled={productsList.length!==0}></input>
      </form>
    </>
  );
}
