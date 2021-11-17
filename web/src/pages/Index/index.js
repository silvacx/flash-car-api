import React, { useState, useEffect } from 'react';
import { FiTrash2 } from 'react-icons/fi';

import api from '../../services/api';

import './styles.css';

import logoImg from '../../assets/logo.png';

export default function Index() {
    const [imagems, setImages] = useState([]);

    const ongId = localStorage.getItem('ongId');


    useEffect(() => {
        api.get('/image', {
            headers: {
                Authorization: ongId,
            }
        }).then(response => {
            setImages(response.data);
        })
    }, [ongId]);

    async function handleDeleteImagems(id) {
        try{
            await api.delete(`image/${id}`, {
                headers: {
                    Authorization: ongId,
                }
            });
            setImages(imagems.filter(imagem => imagem.id !== id));
        } catch (err) {
            alert('Erro ao deletar caso, tente novamente.');
        }
    }

    return(
        <div className="index-container">
            <header>
                <img src={logoImg} alt="Logo"/>
            </header>
            <h1>Imagens Cadastradas</h1>

            <ul>
                {imagems.map(imagem => (
                    <li key={imagem.id}>

                    <strong>{imagem.description}</strong>
                    
                    <p><img src={`data:image/svg;base64,${imagem.imageBase64}`} alt={imagem.description} /></p>
                    
                    <button onClick={() => handleDeleteImagems(imagem.id)} type="button">
                        <FiTrash2 size={20}/>
                </button>
                </li>
                ))}
           </ul>
        </div>
    );
}