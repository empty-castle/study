const path = require('path');
const HtmlWebPackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: {
        index: './source/index.js',
        about: './source/about.js'
    },
    output: {
        path: path.resolve(__dirname, 'public'),
        filename: '[name]_bundle.js'
    },
    module: {
        rules: [
            {
                test:/\.css$/,
                use: [
                    //뒤 쪽에 있는 로더가 먼저 실행된다.
                    'style-loader', //css-loader 가 읽은 css 를 적용
                    'css-loader' //css 파일을 읽는 로더
                ]
            }
        ]
    },
    plugins: [
        new HtmlWebPackPlugin({
            template: './source/index.html',
            filename: './index.html',
            chunks: ['index']
        }),
        new HtmlWebPackPlugin({
            template: './source/about.html',
            filename: './about.html',
            chunks: ['about']
        }),
    ]
};