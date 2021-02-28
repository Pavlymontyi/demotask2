<a href = "/person">Spenders</a>
<a href = "/category">Expense Categories</a>
<a href = "/expense">Expenses</a>

<div id="header">
    <h2>All categories</h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add New Category</legend>
        <form name="category" action="/category" method="post">
            Name : <input type="text" name="name" /><br/>
            <input type="submit" value="Save" />
        </form>
    </fieldset>

    <table class="datatable">
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <#list model["categories"] as category>
            <tr>
                <td>${category.name}</td>
                <td>
                    <a href="category/${category.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
</div>