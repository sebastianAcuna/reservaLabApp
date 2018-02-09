//para instanciar un menu    

@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //se infla el menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //se prepara el onclick
        switch (item.getItemId()){
            case R.id.add_name:
                //addName(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }