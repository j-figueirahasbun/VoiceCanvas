// SearchResultsList.tsx
import React from 'react';

interface SearchResult {
  username: string;
}

interface Props {
  searchResults: SearchResult[];
}

const SearchResultsList: React.FC<Props> = ({ searchResults }) => {
  return (
    <div className="py-4 overflow-y-auto">
      {searchResults.map((result, index) => (
        <div key={index} className="flex items-center justify-center relative">
          <div className="font-semibold text-gray-900 dark:text-white">{result.username}</div>
        </div>
      ))}
    </div>
  );
}

export default SearchResultsList;


<h2 className="text-base font-bold text-gray-700 dark:text-white">
Search </h2>