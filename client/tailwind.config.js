/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      margin: {
        '0': '0',
      },
      padding: {
        '0': '0',
      },
      colors: {
        custom: {
          'light': '#DDC7A0',
          'lightdarker': '#B09F80',
          'accent': '#C87620',
          'accentlight': '#db906b',
          'dark': '#736013',
          'darker': '#722720',
        },
      },
    },
  },
  plugins: [],
}