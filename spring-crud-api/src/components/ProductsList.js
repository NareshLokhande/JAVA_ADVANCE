import { useEffect, useState } from "react"
import { getAllProducts, removeProduct } from "../services/ProductService"


export function Productslist() {
    
    const [Productslist,setProductsList] = useState([]);
    const [errorMessage, setErrorMessage] = useState([""]);

    async function fetchProducts(){
        try {
            const response = await getAllProducts();
            if (response.status === 200) {
                console.log(response.data.products);
                setProductsList(response.data.Products);
            }
        } catch (error) {

            if (error.response.status === 404) {    
            console.log(error);
            setProductsList([]);
            setErrorMessage(error.response.data.message);
            }
        }   
    }

    useEffect(()=>{
        fetchProducts();
    },[]);

    return(
        <>
            <h1>Products List</h1>
            
            <table border={1} cellPadding={10} cellSpacing={0}>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
                {
                    Productslist.map((product)=>{
                        return (
                            <tr>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.price}</td>
                                <td>{product.quantity}</td>
                                <td><input type="button" value="delete" onClick={()=>{
                                    removeProduct(product.id);
                                    fetchProducts();
                                }}>
                                </input></td>
                            </tr>
                        )
                    })
                }
            </table>:<h5>{errorMessage}</h5>;
        </>
    );
}