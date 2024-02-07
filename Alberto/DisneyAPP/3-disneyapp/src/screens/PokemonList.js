import React, { useState, useEffect } from 'react';
import { View, Text, FlatList } from 'react-native';


const PokemonList = () => {
    const [pokemons, setPokemons] = useState([]);
    useEffect (() => {
        fetch ("https://pokeapi.co/api/v2/pokemon?limit=1302")
        .then ((response) => response.json())
        .then ((data) => setPokemons(data.results))
    }, []);

    return (
        <FlatList 
            data={pokemons}
            keyExtractor={(item) => item.name}
            renderItem={({ item }) => 
                <View>
                <Text>{item.name}</Text>
                </View>
            }
        />  
    );
};




export default PokemonList;



